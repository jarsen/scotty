#!/bin/bash
echo "Building .jar"
lein jar
echo "Copying to server"
cp target/scotty-1.0.0-SNAPSHOT.jar ../server/plugins
