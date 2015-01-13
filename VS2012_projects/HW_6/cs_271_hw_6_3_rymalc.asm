TITLE HW_6_1

; Charles Rymal
; CS 271
; HW 6
; 3/13/2014

; Chapter 12 Problem 1
; perform float comparison

INCLUDE Irvine32.inc

.data
prompt		BYTE "enter floats X and Y",0dh,0ah,0

less		BYTE "X is lower",0dh,0ah,0
less_not	BYTE "X is not lower",0dh,0ah,0

.code

main PROC
	
ML:

	mov  edx,OFFSET prompt
	call WriteString

	call ReadFloat
	call ReadFloat

	fcompp
	fnstsw ax
	sahf

	ja   L1
	jmp  L2
L1:
	mov  edx,OFFSET less
	call WriteString
	jmp  L3
L2:
	mov  edx,OFFSET less_not
	call WriteString
L3:
	
	jmp ML

	exit
main ENDP

END main





