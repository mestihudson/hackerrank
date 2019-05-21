#!/bin/sh +x
cd "$1"
while true; do
  clear &&
  echo '----------' &&
  sleep 1 &&
  inotifywait -m --exclude "target" "$1" -r -e modify |mvn clean test -q
done
cd -
