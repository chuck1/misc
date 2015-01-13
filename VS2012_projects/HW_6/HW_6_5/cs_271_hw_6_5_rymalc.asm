TITLE HW_6_1

; Charles Rymal
; CS 271
; HW 6
; 3/13/2014

; Chapter 12 Problem 6
; calculate quadratic formula for real roots

INCLUDE Irvine32.inc

.data
prompt		BYTE "enter a, b, and c",0dh,0ah,0

msg_pos		BYTE "d is positive",0dh,0ah,0
msg_neg		BYTE "d is negative",0dh,0ah,0

two REAL8 2.

a_	REAL8 1.
b_	REAL8 5.
c_	REAL8 3.
d_	REAL8 ?

x1	REAL8 ?
x2	REAL8 ?

four REAL8 4.

.code

; (-b +- sqrt( bb - 4ac )) / 2a
; 4 a c * * b b * -

; d = bb - 4ac

; -b sqrt(d) + 2 a * /
; -b sqrt(d) - 2 a * /

calc_d PROC

	fld  b_
	fmul ST(0),ST(0)

	fld  four
	fld  a_
	fld  c_
	fmul
	fmul

	fsub

	fstp  d_

	ret
calc_d ENDP

main PROC

ML:

	mov  edx,OFFSET prompt
	call WriteString
	call ReadFloat
	fstp a_
	call ReadFloat
	fstp b_
	call ReadFloat
	fstp c_


	fld  b_
	fchs

	; calculate discriminant
	call calc_d
	fld  d_

	; make sure it is positive
	fldz
	fcomip ST(0),ST(1)

	ja	 L_neg
	jmp  L_pos
L_neg:
	mov  edx,OFFSET msg_neg
	call WriteString
	jmp  ML
L_pos:
	mov  edx,OFFSET msg_pos
	call WriteString

	fsqrt
	fsub
	fld  two
	fld  a_
	fmulp
	fdivp

	call WriteFloat
	call CrLf
	fst  x1

	fld  b_
	fchs
	fld  d_
	fsqrt
	fadd

	fld  two
	fld  a_
	fmul
	fdiv
	call WriteFloat
	call CrLf
	fst  x2

	jmp ML

	exit
main ENDP

END main





