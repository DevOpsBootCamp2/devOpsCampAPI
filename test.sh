#!/bin/sh

/usr/bin/java -jar /DevOpsCampAPI-0.0.1-SNAPSHOT.jar &
ID=$! # ID of webserver process, so we can kill it

tests_passed=true
expected="{\"status\":\"UP\"}"
output=$(curl -s localhost:8090/health)
echo "$output"
if [[ "$expected" != "$output" ]]; then
  echo "Test Failure"
  echo "$expected != $output"
  tests_passed=false
fi

kill $ID

if [[ "$tests_passed" == "true" ]]; then
  echo "Passed Tests"
else
  echo "Failed Tests"
  exit 1
fi
