#!/bin/sh
[ -s "diff.txt" ] && svn commit -m "automatic commit"

svn up


