#!/bin/bash
if [ "$*" == "" ]; then
    echo "No arguments provided : Please enter the router port number in command line"
    exit 1
fi
echo Router port number $*
javac Mainpgm.java -Xlint:unchecked
java Mainpgm $*
javac linkState.java
java linkState

