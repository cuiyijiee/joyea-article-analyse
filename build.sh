#!/bin/zsh

./gradlew build
mv build/libs/*.jar release
cd release
git commit -ama
git push 
