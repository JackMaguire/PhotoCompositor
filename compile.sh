#!/bin/bash

#\rm -rf build
if [ ! -d build ]; then
    mkdir build
fi

for application in `grep 'public static void main' -r src | awk -F: '{print $1}' | awk -Fsrc/ '{print $2}' | awk -F.java '{print $1}'`; do

    runtime_flags=""
    #runtime_flags="-Xverify:none" #VisualVM

    javac -d build/ -cp src src/${application}.java

    #temp=`echo $application | sed 's:/:.:g'`
    #java $runtime_flags -cp build $temp
done
