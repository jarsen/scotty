(ns scotty.core
    (:require [cljminecraft.bukkit :as bk]
              [cljminecraft.blocks :as blocks]
              [cljminecraft.events :as ev]
              [cljminecraft.entity :as ent]
              [cljminecraft.player :as plr]
              [cljminecraft.util :as util]
              [cljminecraft.logging :as log]
              [cljminecraft.config :as cfg]
              [cljminecraft.commands :as cmd]
              [cljminecraft.recipes :as r]
              [cljminecraft.items :as i]
              [cljminecraft.files :as f]
              [clojure.string :as str]))

(defonce plugin (atom nil))

(def beacons (atom {}))

(defn teleport-to-player
  "Teleport sender to a target player with name"
  [sender player]
  (.teleport sender (.getLocation player))
  {:msg (format "Beamed to %s" (.getDisplayName player))})


(defn summon-player
  "Summon target player to sender"
  [sender player]
  (.teleport player (.getLocation sender))
  {:msg (format "%s beamed to you." (.getDisplayName player))})


(defn teleport-home
  "Teleport sender to where they last slept."
  [sender]
  (if-let [location (.getBedSpawnLocation sender)]
    (.teleport sender location)
    {:msg "You must have a valid bed spawn location."}))

(defn beam
  "Beam sender to specified beacon"
  [sender beacon-name]
  (if-let [location (@beacons beacon-name)]
    (.teleport sender location)
    {:msg (format "Cannot find beacon named %s" beacon-name)}))

(defn set-beacon
  "Set a beacon at the sender's current location"
  [sender beacon-name]
  (if-let [location (.getLocation sender)]
    (swap! beacons assoc beacon-name location)))

(defn list-beacons
  "Return a list of beacons placed by the sender"
  [sender]
  (.sendRawMessage sender "---- Beacons ----")
  (.sendRawMessage sender (str/join \newline (keys @beacons))))
  ; (for [beacon-name (keys @beacons)]
  ;   (.sendRawMessage sender beacon-name)))

; (defn events []
;   [(ev/event "block.sign-change" #'sign-change)])

(defn register-commands []
  (cmd/register-command @plugin "tp" #'teleport-to-player :player)
  (cmd/register-command @plugin "summon" #'summon-player :player)
  (cmd/register-command @plugin "home" #'teleport-home)
  (cmd/register-command @plugin "beam" #'beam :string)
  (cmd/register-command @plugin "set-beacon" #'set-beacon :string)
  (cmd/register-command @plugin "list-beacons" #'list-beacons :string))

(defn start
  [plugin-instance]
  (log/info "Scotty reporting for duty.")
  (reset! plugin plugin-instance)
  ; (ev/register-eventlist @plugin (events))
  (register-commands))

(defn stop
  [plugin]
  (log/info "Stopping Scotty."))

