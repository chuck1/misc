TITLE HW_6_1

; Charles Rymal
; CS 271
; HW 6
; 3/13/2014

; Chapter 12 Problem 5
; calculate area of circle

INCLUDE Irvine32.inc

.data
prompt BYTE "enter radius:",0dh,0ah,0

.code

main PROC
	
ML:

	mov  edx,OFFSET prompt
	call WriteString

	call ReadFloat
	
	fmul ST(0), ST(0)

	fldpi
	
	fmulp ST(1), ST(0)

	call WriteFloat
	call CrLf

	ffree ST(0)

	jmp ML

	exit
main ENDP

END main





