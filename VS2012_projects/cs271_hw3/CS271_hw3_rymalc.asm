TITLE MASM Template						(main.asm)

; Charles Rymal
; CS 271
; Winter 2014
; Homework 3
; 2/5/2014
; 
; 1. prompt for user name and greet the user
; 2. prompt for integer
; 3. display entered value and current count, sum, and average
; 4. repeat from step 2 until negative integer is entered
; 6. say goodbye


INCLUDE Irvine32.inc


.data
NAME_LEN = 32
SPACE_LEN = 32
MAX = 100

welcome		BYTE "Charles Rymal",0dh,0ah,"Assignment 3",0dh,0ah,"Enter your name: ",0
greeting	BYTE "Hello, ",0
farwell		BYTE "Goodbye, ",0
prompt		BYTE "next:  ",0
instr1		BYTE "Enter integers between 0 and ",0
instr2		BYTE " to append the list",0dh,0ah,"Enter integer less than or equal to zero to exit",0dh,0ah,0dh,0ah,0
heading		BYTE "   count   value     sum     avg               first: ",0
msg_high	BYTE "integer is too high, try again: ",0
msg_count	BYTE "number of non-negative integers entered ",0
msg_sum		BYTE "sum                                     ",0
msg_avg		BYTE "average                                 ",0
spaces		BYTE SPACE_LEN dup(020h)
name_arr	BYTE NAME_LEN dup(0)

rounding	REAL4 1000.

sum			DWORD 0
count		DWORD 0
avg			REAL4 ?

dec_width	DWORD ?


.code

GetWidth PROC
	; Determines number of characters in decimal integer
	; Receives: eax - integer
	; Returns:  eax - width

	pushad
	
	mov  ecx,0
	mov  ebx,10
L1:
	mov  edx,0
	div  ebx
	
	inc  ecx

	cmp  eax,0
	jg   L1

	mov  dec_width,ecx
	
	popad
	
	mov  eax,dec_width

	ret
GetWidth ENDP

WriteDecFixed PROC
	; Prints decimal integer with up to SPACE_LEN leading spaces
	; Receives: EAX - integer to display
	;           EBX - column width
	
	pushad
	
	push eax

	call GetWidth

	sub  ebx,eax

	cmp  ebx,0
	jl   L1

	mov  eax,ebx
	call WriteSpace

L1:	pop  eax
	call WriteDec
	
	popad

	ret
WriteDecFixed ENDP

WriteSpace PROC
	; Prints up to SPACE_LEN spaces
	; Receives: EAX - column width
	
	pushad
	
	cmp  eax,SPACE_LEN - 1
	jg   L1
	jmp  L2
L1: mov  eax,SPACE_LEN - 1
L2:
	
	mov  ebx,OFFSET spaces
	add  ebx,eax
	mov  BYTE PTR [ebx],0

	mov  edx,OFFSET spaces
	call WriteString
	
	mov  BYTE PTR [ebx],020h
	
	popad

	ret
WriteSpace ENDP

ProcWelcome PROC
	; Displays welcome message, prompts user for name, greets user

	; welcome
	mov  edx,OFFSET welcome
	call WriteString

	; read user name
	mov  ecx,NAME_LEN
	mov  edx,OFFSET name_arr
	call ReadString

	; greet user
	mov  edx,OFFSET greeting
	call WriteString

	mov  edx,OFFSET name_arr
	call WriteString
	call Crlf
	
	; instructions
	mov  edx,OFFSET instr1
	call WriteString

	mov  eax,MAX
	call WriteDec

	mov  edx,OFFSET instr2
	call WriteString

	; table heading
	mov  edx,OFFSET heading
	call WriteString
	
	ret
ProcWelcome ENDP

DispLine PROC
	; Prints the current most recently entered value and
	; the current count, sum, and average
	; Receives: EAX - most recently entered value

	; Column width
	mov  ebx,8

	push eax

	; Print count
	mov  eax,count
	call WriteDecFixed

	; Print recently entered value
	pop  eax
	call WriteDecFixed
	
	; Print sum
	mov  eax,sum
	call WriteDecFixed

	; Print 4 spaces
	mov  eax,4
	call WriteSpace
	
	; Calculate and print average
	fild  sum
	fidiv count
	fmul  rounding
	frndint
	fdiv  rounding

	call  WriteFloat

	fstp  st

	; Print 4 spaces
	mov  eax,4
	call WriteSpace

	; Prompt for next value
	mov  edx,OFFSET prompt
	call WriteString

	ret
DispLine ENDP


main PROC
	call ProcWelcome

	jmp  main_loop
retry_high:
	mov  edx,OFFSET msg_high
	call WriteString
	
main_loop:

	call ReadInt
	
	cmp  eax,0
	jl   exit_loop
	
	cmp  eax,MAX
	jg   retry_high
	
	add  sum,eax
	inc  count
	
	call DispLine

	jmp main_loop

exit_loop:
	
	call CrLf
	
	mov  edx,OFFSET farwell
	call WriteString

	mov  edx,OFFSET name_arr
	call WriteString
	call CrLf

	exit

main ENDP
END main





