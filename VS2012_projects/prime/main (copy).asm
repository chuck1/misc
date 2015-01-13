TITLE MASM Template						(main.asm)

INCLUDE Irvine32.inc
.data

msg0 BYTE "Assignment 1 by Charles Rymal",0dh,0ah,"Enter 0 to exit",0dh,0ah,0
msg1 BYTE "Enter Integer A:",0dh,0ah,0
msg2 BYTE "Enter Integer B:",0dh,0ah,0
msg3 BYTE "A + B = ",0
msg4 BYTE "A - B = ",0
msg5 BYTE "A * B = ",0
msg6 BYTE "A / B = ",0
msg7 BYTE " R ",0
msg8 BYTE "Exit requested",0dh,0ah,"Exiting",0dh,0ah,0
msg9 BYTE "Error: B > A",0dh,0ah,"Exiting",0dh,0ah,0
msg10 BYTE "Enter Integer 2:",0dh,0ah,0
msg11 BYTE "Enter Integer 2:",0dh,0ah,0


num1 DWORD 0
num2 DWORD 0

.code
input PROC
	call WriteString
	call ReadInt
	mov  [ebx],eax
	cmp  eax,0
	ret
input ENDP

result PROC
	call WriteString
	call WriteInt
	call Crlf
	ret
result ENDP

main PROC
	call Clrscr

	mov  edx,OFFSET msg0
	call WriteString
	
L1:
	; get user input
	mov  edx,OFFSET msg1
	mov  ebx,OFFSET num1
	call input
	je   L2
	
	; get user input
	mov  edx,OFFSET msg2
	mov  ebx,OFFSET num2
	call input
	je   L2
	
	mov  eax,num1
	cmp  eax,num2
	jl   L3

	; add
	mov  eax,num1
	add  eax,num2

	mov  edx,OFFSET msg3
	call result

	; sub
	mov  eax,num1
	sub  eax,num2

	mov  edx,OFFSET msg4
	call result

	; mul
	mov  eax,num1
	mul  num2

	mov  edx,OFFSET msg5
	call result

	; div
	mov  eax,num1
	mov  edx,0
	div  num2
	push edx

	mov  edx,OFFSET msg6
	call WriteString
	call WriteInt
	mov  edx,OFFSET msg7
	call WriteString
	pop  eax
	call WriteInt
	call Crlf

	jmp  L1
L2:
	mov  edx,OFFSET msg8
	call WriteString

	exit
L3:
	mov  edx,OFFSET msg9
	call WriteString

	exit
main ENDP

END main

