TITLE HW_6_1

; Charles Rymal
; CS 271
; HW 6
; 3/13/2014

; Chapter 9 Problem 10
; generate random 4x4 matrices of capital letters

INCLUDE Irvine32.inc

.data
myMessage BYTE "Assembly language program example",0dh,0ah,0

conso BYTE "BCDFGHJKLMNPQRSTVWXYZ"
vowel BYTE "AEIOU"

array BYTE 4 dup(4 dup(0))

.code

ByteMatrix PROC
	LOCAL arr:DWORD
	pushad

	mov  eax,[ebp + 8]
	mov  arr,eax

	mov  ecx,16

	mov  edi,0

L1:
	mov  esi,arr

	mov  eax,2
	call RandomRange
	
	cmp  eax,0

	je   L_conso
	jmp  L_vowel
L_conso:
	mov  eax,21
	call RandomRange

	mov  bl,[conso + eax]
	
	jmp  L2
L_vowel:
	mov  eax,5
	call RandomRange

	mov  bl,[vowel + eax]
L2:
	mov  [esi + edi],bl
	inc  edi

	mov  al,bl
	;call WriteChar
	;call CrLf
	
	loop L1

	popad
	ret
ByteMatrix ENDP

ByteMatrix_Disp PROC
	LOCAL arr:DWORD
	pushad

	mov  eax,[ebp + 8]
	mov  arr,eax

	
	; row offset
	mov  esi,arr


	mov  ecx,4

	D1:
		push ecx
		mov  ecx,4

		; column offset
		mov  edi,0

		D2:
			mov  eax,0
			mov  al,BYTE PTR [esi + edi]

			call WriteChar

			inc  edi

		loop D2

		call CrLf

		pop  ecx

		add  esi,4

	loop D1

	popad
	ret
ByteMatrix_Disp ENDP

main PROC

	call Randomize

	mov  ecx,5

M1:

	push OFFSET array
	call ByteMatrix

	call ByteMatrix_Disp
	add  esp,4

	call CrLf

	loop M1


	exit
main ENDP

END main





