#!/bin/bash

application="app_one/AppOne"
temp=`echo $application | sed 's:/:.:g'`

runtime_flags=""
#runtime_flags="-Xverify:none" #VisualVM

\rm -rf build
mkdir build
javac -d build/ -cp src src/applications/${application}.java
#java $runtime_flags -cp build applications.$temp
