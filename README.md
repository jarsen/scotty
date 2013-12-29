#Scotty
![transporter room](http://www.mindpollution.org/wp-content/uploads/2013/05/beam-me-up-star-trek.jpg)

Scotty is a simple [bukkit minecraft server](http://dl.bukkit.org) plugin supporting several simple teleportation related commands. This is definitely not ready yet to run on a public server because it will undoubtedly lead to much griefing.

Since this is written in clojure it's obviously cooler than any plugins written in Java. No, but for real [clj-minecraft](https://github.com/CmdrDats/clj-minecraft) gives you some nice things for free, like tab autocompletion for certain command arguments (like players). For example, start doing the `/tp` command and start typing in a players name and then hit tab—et voila—the players name is autocompleted. Great for players with long or mispelled names.

## Commands
Scotty adds the following commands:

* `/home` - teleports you to your bed spawn location. may or may not handle errors correctly.
* `/tp` - teleports you to a specified player (autocompletes)
* `/summon` - teleports a specified player to you (probably need to pick a better name for this because apparently some plugins use summon to summon creatures etc. need to figure out how to deal with namespacing in general, actually). (autocompletes)
* `/set-beacon` - set a beacon at your current location with a given name. for example: `/set-beacon obsidian-mine`
* `/list-beacons` - list all the beacons in the world. literally. right now beacons are not private to the player that created them. anyone can teleport or move any beacon anywhere. This won't work well for public servers with griefers, obviously. Better changes to come. Also, beacons are not yet persistent–they will be lost when the server restarts. This is not ideal.
* `/beam` - teleport yourself to the named beacon. This doesn not yet support autocomplete, but clj-minecraft is designed such that you can add your own. This feature will be forthcoming. (autocompletes)

## Setup

To build and run this you first need to install [bukkit](http://www.mindpollution.org/wp-content/uploads/2013/05/beam-me-up-star-trek.jpg), then build [clj-minecraft](https://github.com/CmdrDats/clj-minecraft) and shove it in your plugins folder.

I've got this simple build.sh script that is a piece of dirt and assumes that your scotty folder is sitting in the same folder as a folder named server that has your bukkit jar and plugins/ folder. Maybe this will be fixed in the future.
