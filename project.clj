(defproject scotty "1.0.0-SNAPSHOT"
  :description "Minecraft Bukkit Plugin for teleporting peeps all around."
  :plugins [[lein-git-deps "0.0.1-SNAPSHOT"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.3"]
                 [org.bukkit/bukkit "1.7.2-R0.2"]]
  :git-dependencies [["https://github.com/jarsen/clj-minecraft.git"]]
  :repl-options [:init nil :caught clj-stacktrace.repl/pst+]
  :repositories [["bukkit.snapshots" "http://repo.bukkit.org/content/repositories/snapshots"]
                 ["bukkit.releases" "http://repo.bukkit.org/content/repositories/releases"]])
