TITLE hw_5_1

; Charles Rymal
; CS 271
; Winter 2014
; Homework 5 Prob 1
; 3/3/2014

INCLUDE Irvine32.inc

PDWORD TYPEDEF PTR DWORD

.data

array DWORD 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15

.code

; reverse the contents of an array, regardless of the datatype
reverse PROC
	LOCAL parray:DWORD, len:DWORD, halflen:DWORD, arr_type:DWORD
    
	; array offset
    mov  eax,[ebp + 8]
	mov  parray,eax
	
	; length
    mov  eax,[ebp + 12]
	mov  len,eax

	; size of type
	mov  eax,[ebp + 16]
	mov  arr_type,eax

	; calculate half length
	mov  eax,len
	mov  ebx,2
	mov  edx,0
	div  ebx
	mov  halflen,eax

	; initialize
	mov  ecx,halflen

	; index formulas
	; 1st = len - ecx
	; 2nd = ecx - 1

	; allocate stack space for temporary storage
	sub  esp,4

	; the stack in this loop
	; | esp + 12   | esp + 8    | esp + 4 |  esp |
	; | 1st offset | 2nd offset | ecx     | temp |

	; loop
reverse_loop:
	; caluclate first offset
	mov  eax,len
	sub  eax,ecx
	mul  arr_type
	add  eax,parray
	push eax
	
	; calculate second offset
	mov  eax,ecx
	dec  eax
	mul  arr_type
	add  eax,parray
	push eax
	
	; save ecx
	push ecx

	; allocate stack space for temporary storage
	sub  esp,4

	; swap values
	cld
	mov  esi,[esp + 8]
	mov  edi,esp
	mov  ecx,arr_type
	rep  movsb

	cld
	mov  esi,[esp + 12]
	mov  edi,[esp + 8]
	mov  ecx,arr_type
	rep  movsb

	cld
	mov  esi,esp
	mov  edi,[esp + 12]
	mov  ecx,arr_type
	rep  movsb

	; clean stack
	add  esp,4
	pop  ecx
	add  esp,8

    loop reverse_loop

	ret
reverse ENDP

main PROC
    
	push TYPE array
	push LENGTHOF array
    push OFFSET array
    call reverse
    add  esp,12
    

	mov  esi,OFFSET array
	mov  ecx,LENGTHOF array
	mov  ebx,TYPE array
	call DumpMem

	exit
main ENDP
END main



