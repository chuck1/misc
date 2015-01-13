TITLE HW_6_1

; Charles Rymal
; CS 271
; HW 6
; 3/13/2014

; Chapter 9 Problem 12
; calculate the sum of a row in a 2D array of DWORDs, WORDs, or BYTEs

INCLUDE Irvine32.inc

.data
prompt BYTE "Enter row index",0dh,0ah,0
result_d BYTE "Sum of array_d is",0dh,0ah,0
result_w BYTE "Sum of array_w is",0dh,0ah,0
result_b BYTE "Sum of array_b is",0dh,0ah,0


array_d	DWORD 0, 1, 2, 3
ROW_SIZE_D = $ - array_d
		DWORD 4, 5, 6, 7
ARR_SIZE_D = $ - array_d

array_w	WORD 0, 1, 2, 3
ROW_SIZE_W = $ - array_w
		WORD 4, 5, 6, 7
ARR_SIZE_W = $ - array_w

array_b	BYTE 0, 1, 2, 3
ROW_SIZE_B = $ - array_b
		BYTE 4, 5, 6, 7
ARR_SIZE_B = $ - array_b


row_index		DWORD ?
sum				DWORD ?



.code

calc_row_sum PROC
	LOCAL arr_loc:DWORD, type_loc:DWORD, arr_size_loc:DWORD, row_size_loc:DWORD, row_index_loc:DWORD, sum_loc:DWORD
	pushad

	mov  eax,[ebp + 24]
	mov  arr_loc,eax

	mov  eax,[ebp + 20]
	mov  type_loc,eax

	mov  eax,[ebp + 16]
	mov  arr_size_loc,eax

	mov  eax,[ebp + 12]
	mov  row_size_loc,eax

	mov  eax,[ebp + 8]
	mov  row_index_loc,eax


	; row offset
	mov  eax,row_size_loc
	mov  ebx,row_index_loc
	mul  ebx
	add  eax,arr_loc
	mov  esi,eax
	
	; row_len
	mov  eax,row_size_loc
	mov  edx,0
	mov  ebx,type_loc
	div  ebx
	mov  ecx,eax

	; allocate space on stack for temporary value
	sub  esp,4
	mov  edi,esp

	; set direction flag
	cld

	mov  sum_loc,0
C1:
	push ecx

	mov  eax,0
	mov  [edi],eax

	mov  ecx,type_loc
	rep  movsb

	sub  edi,type_loc

	mov  eax,[edi]
	add  sum_loc,eax

	pop  ecx

	loop C1

	add  esp,4

	popad

	mov  eax,sum_loc

	ret
calc_row_sum ENDP


main PROC
	; get row index from user
	mov  edx,OFFSET prompt
	call WriteString
	call ReadInt
	mov  row_index,eax

	; dword array
	push OFFSET array_d
	push TYPE array_d
	mov  eax,ARR_SIZE_D
	push eax
	mov  eax,ROW_SIZE_D
	push eax
	push row_index
	call calc_row_sum
	add  esp,20

	mov  sum,eax

	mov  edx,OFFSET result_d
	call WriteString

	mov  eax,sum

	call WriteDec
	call CrLf

	; word array
	push OFFSET array_w
	push TYPE array_w
	mov  eax,ARR_SIZE_W
	push eax
	mov  eax,ROW_SIZE_W
	push eax
	push row_index
	call calc_row_sum
	add  esp,20

	mov  sum,eax

	mov  edx,OFFSET result_w
	call WriteString

	mov  eax,sum

	call WriteDec
	call CrLf


	; byte array
	push OFFSET array_b
	push TYPE array_b
	mov  eax,ARR_SIZE_B
	push eax
	mov  eax,ROW_SIZE_B
	push eax
	push row_index
	call calc_row_sum
	add  esp,20

	mov  sum,eax

	mov  edx,OFFSET result_b
	call WriteString

	mov  eax,sum

	call WriteDec
	call CrLf


	exit
main ENDP

END main





