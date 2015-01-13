#!/bin/csh
# name this job
#$ -N fluent_job
#
#$ -q me
#
# use current working directory for input and output - defaults is 
# to use the users home directory
#$ -cwd
#
#$ -m abe
#$ -M rymalc@onid.orst.edu
#
#
# send stdout and stderror to this file
#$ -o job_output.out
#$ -j y
#

#see where the job is being run
hostname

# print date and time
date
# Sleep for 20 seconds
sleep 20
# print date and time again
date
