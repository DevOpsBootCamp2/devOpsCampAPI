#!/bin/bash
echo calling curl
curl -X POST -H 'Content-type: application/json'  --data '{"text":"The Boot Camp Application DevOpsCampAPI has failed. Contact The Alex !!!. :pensive: "}'  https://hooks.slack.com/services/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
echo done