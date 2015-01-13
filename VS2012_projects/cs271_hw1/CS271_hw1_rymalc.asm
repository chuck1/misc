TITLE MASM Template						(main.asm)

; Charles Rymal
; CS 271
; Winter 2014
; Assignment 1
; 01/20/2014

; This program prompts the user for two positive, nonzero integers
; and displays the sum, difference, product, quotient, and remainder.
; If either integer is less than or equal to zero or if the second
; is greater than the first, the program will exit. The program
; will repeat until one of these exit conditions is met.


INCLUDE Irvine32.inc
.data

; various messages
msg0 BYTE "Assignment 1 by Charles Rymal",0dh,0ah,"Enter number less than or equal to zero to exit",0dh,0ah,0
msg1 BYTE "Enter Integer: ",0
msg3 BYTE " + ",0," - ",0," * ",0," / ",0," % ",0," = ",0," < ",0
msg4 BYTE "Exit requested",0dh,0ah,0
msg5 BYTE "Error: ",0
msg6 BYTE "Exiting",0dh,0ah,0

; heres where the integers will be stored
num1 DWORD ?
num2 DWORD ?

.code
input PROC
	; procedure: input
	; read integer (call it x) from console
	; store x at memory offset in ebx
	; compare x to 0

	; inputs
	; ebx	offset at which x will be stored
	
	; outputs
	; eax	x
	; comparison flag for x and 0

	mov  edx,OFFSET msg1
	call WriteString
	call ReadInt
	mov  [ebx],eax
	cmp  eax,0
	ret
input ENDP

result PROC
	; procedure: result
	; display result of integer arithmetic

	; inputs
	; eax	result of expression
	; edx	offset of string containing operation symbol
	
	push eax ; save for later
	
	mov  eax,num1
	call WriteDec
	
	call WriteString
	
	mov  eax,num2
	call WriteDec

	pop  eax ; retrieve result
	cmp  eax,0

	; since num1 > num2, arithmetic operations will never return negative
	; a negative eax here is an indication to skip the last two write calls
	; used for displaying error message "num1 < num2"
	jl   L1

	mov  edx,OFFSET msg3 + 20
	call WriteString
	
	call WriteDec
L1:
	ret
result ENDP

main PROC
	; welcome message
	mov  edx,OFFSET msg0
	call WriteString
	
L1:
	; get user input
	mov  ebx,OFFSET num1
	call input
	jle   L2
	
	; get user input
	mov  ebx,OFFSET num2
	call input
	jle   L2
	
	; check if num1 < num2
	mov  eax,num1
	cmp  eax,num2
	jl   L3

	; add
	mov  eax,num1
	add  eax,num2
	
	mov  edx,OFFSET msg3
	call result
	call Crlf
	
	; sub
	mov  eax,num1
	sub  eax,num2
	
	mov  edx,OFFSET msg3 + 4
	call result
	call Crlf

	; mul
	mov  eax,num1
	mul  num2

	mov  edx,OFFSET msg3 + 8
	call result
	call Crlf

	; div
	mov  eax,num1
	mov  edx,0
	div  num2
	push edx ; save mod
	
	mov  edx,OFFSET msg3 + 12
	call result
	call Crlf
	
	mov  edx,OFFSET msg3 + 16
	pop  eax ; retrieve mod
	call result
	call Crlf
	
	jmp  L1 ; repeat
L2:
	; exit requested
	mov  edx,OFFSET msg4
	call WriteString
	mov  edx,OFFSET msg6
	call WriteString
	exit
L3:
	; error num1 < num2
	mov  edx,OFFSET msg5
	call WriteString

	mov  edx,OFFSET msg3 + 24
	mov  eax,-1 ; used to suppress last two write instructions in "result" procedure
	call result
	call Crlf

	mov  edx,OFFSET msg6
	call WriteString
	exit
main ENDP

END main



