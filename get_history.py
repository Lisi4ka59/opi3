#!/usr/local/bin/python3.9
import subprocess
import re
import sys

subprocess.run(["svn up"], shell=True)
result = str(subprocess.run(["svn info --show-item revision"], shell=True, capture_output=True).stdout)
resint = int(re.sub('\D', '', result))
subprocess.run(["rm -rf history"], shell=True)
subprocess.run(["svn co -r " + str(resint) + " file:///home/studs/s368570/web3svn history"], shell=True, capture_output=True).stderr
res = str(subprocess.run(["ant", "compile"], cwd="history", capture_output=True).stdout)

if ("SUCCESSFUL" in res):
	print("current version compile successfully")
	sys.exit
while (not "SUCCESSFUL" in res) and resint > 1:
	resint -= 1
	subprocess.run(["rm -rf history"], shell=True)
	subprocess.run(["svn co -r " + str(resint) + " file:///home/studs/s368570/web3svn history"], shell=True, capture_output=True)
	res = str(subprocess.run(["ant", "compile"], cwd="history", capture_output=True).stdout)
if (resint == 1) and not "SUCCESSFUL" in res:
	print("none of the project revision could compile")
	sys.exit
subprocess.run(["svn co -r " + str(resint + 1) + " file:///home/studs/s368570/web3svn history_next"], shell=True, capture_output=True)
diff = str(subprocess.run(["diff -r history/ history_next/"], shell=True, capture_output=True).stdout)
with open("history_diff", "w") as file:
	file.write(diff) 

print("project revision " + str(resint) + " compile successfully, differents between this version and next one was written into diff_history file")
