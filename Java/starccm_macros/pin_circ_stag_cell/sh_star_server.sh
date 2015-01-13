#!/bin/csh

#$ -N star_server
#$ -q me,netl
#$ -cwd

#$ -o log_star_server.log
#$ -j y

# number of slots requested from env
#$ -pe mpich 2


# commands
starccm+ -rsh ssh -server -np 2 -on `cat $TMPDIR/machines | xargs` sim.sim
