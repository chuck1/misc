TITLE hw_5_4

; Charles Rymal
; CS 271
; Winter 2014
; Homework 5 Prob 4
; 3/3/2014

INCLUDE Irvine32.inc

.data

VOWEL_COUNT = 2

;                ZYXWVUTSRQPONMLKJIHGFEDCBA
vowel_mask DWORD 00000100000100000100010001b

matrix	BYTE "POAZ"
ROW_SIZE1 = $ - matrix
		BYTE "AEAU"
		BYTE "GKAE"
		BYTE "IAGD"
MAT_SIZE = $ - matrix

row_size DWORD ?
col_size DWORD ?
diag_size DWORD ?

.code

Check_set PROC
	LOCAL array:DWORD, stride:DWORD, len:DWORD, count:DWORD
	pushad

	mov  eax,[ebp + 16]
	mov  array,eax

	mov  eax,[ebp + 12]
	mov  stride,eax

	mov  eax,[ebp + 8]
	mov  len,eax

	mov  count,0

	mov  esi,array
	mov  ecx,len
L1:
	push ecx
	
	mov  cl, BYTE PTR [esi]
	sub  cl,'A'
	
	mov  ebx,1
	shl  ebx,cl
	and  ebx,vowel_mask

	jnz  is_vowel
	jmp  is_not_vowel
is_vowel:
	inc  count
is_not_vowel:

	add  esi,stride

	pop  ecx
	loop L1

	popad
	mov  eax,count
	ret
Check_set ENDP


Write_set PROC

LOCAL array:DWORD, stride:DWORD, len:DWORD
	pushad

	mov  eax,[ebp + 16]
	mov  array,eax

	mov  eax,[ebp + 12]
	mov  stride,eax

	mov  eax,[ebp + 8]
	mov  len,eax

	mov  esi,array
	mov  ecx,len
L1:
	mov  eax,0
	mov  al, BYTE PTR [esi]
	
	call WriteChar

	add  esi,stride

	loop L1

	call CrLf

	popad
	ret
Write_set ENDP

main PROC
	mov  row_size,ROW_SIZE1

	; calculate size of column and diagonal
	mov  edx,0
	mov  eax,MAT_SIZE
	mov  ebx,ROW_SIZE
	div  ebx
	mov  col_size,eax

	cmp  col_size,ROW_SIZE1
	jg   col_grtr
	jmp  row_grtr
col_grtr:
	mov  eax,row_size
	mov  diag_size,eax
row_grtr:
	mov  eax,col_size
	mov  diag_size,eax




	; rows
	mov  ecx,ROW_SIZE
	mov  esi,OFFSET matrix
row_loop:
	push esi			; array
	push 1				; stride
	push ROW_SIZE		; len
	call Check_set

	cmp  eax,VOWEL_COUNT
	je   row_has_two
	jmp  row_doesnt_have_two
row_has_two:
	call Write_set
row_doesnt_have_two:
	add  esp,12

	add  esi,ROW_SIZE

	loop row_loop




	; columns
	mov  ecx,col_size
	mov  esi,OFFSET matrix
col_loop:
	push esi			; array
	push row_size		; stride
	push col_size		; len
	call Check_set

	cmp  eax,VOWEL_COUNT
	je   col_has_two
	jmp  col_doesnt_have_two
col_has_two:
	call Write_set
col_doesnt_have_two:
	add  esp,12

	add  esi,1

	loop col_loop
	



	; diagonal 1
	
	mov  eax,row_size
	inc  eax

	push OFFSET matrix	; array
	push eax			; stride
	push diag_size		; len
	call Check_set

	cmp  eax,VOWEL_COUNT
	je   d1_has_two
	jmp  d1_doesnt_have_two
d1_has_two:
	call Write_set
d1_doesnt_have_two:
	add  esp,12



	; diagonal 2

	mov  eax,row_size
	dec  eax
	
	mov  ebx,OFFSET matrix
	add  ebx,eax

	push ebx			; array
	push eax			; stride
	push diag_size		; len
	call Check_set

	cmp  eax,VOWEL_COUNT
	je   d2_has_two
	jmp  d2_doesnt_have_two
d2_has_two:
	call Write_set
d2_doesnt_have_two:
	add  esp,12



	exit
main ENDP
END main

