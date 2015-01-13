TITLE MASM Template						(main.asm)

; Charles Rymal
; CS 271
; Winter 2014
; Homework 5 Prob 2
; 3/3/2014

INCLUDE Irvine32.inc

.data

target BYTE "ABBCDDEFFGHHIJJKLL",0
freqTable DWORD 256 DUP(0)

.code

Get_frequencies PROC
    LOCAL array:PTR BYTE, len:DWORD, freq:DWORD
    pushad

	; load parameters into local variables

	mov  eax,[ebp + 16]
	mov  len,eax

    mov  eax,[ebp + 12]
	mov  array,eax

    mov  eax,[ebp + 8]
	mov  freq,eax

	; initialize loop
    mov  ecx,len
    
freq_loop:

	; calculate offset
	mov  eax,array
	sub  eax,1
	add  eax,ecx
	
	; get value
	mov  ebx,0
	mov  bl,[eax]
	
	; increment frequency table
	mov  eax,freq
	inc  DWORD PTR [eax + ebx * 4]
	
    loop freq_loop

    popad
	ret
Get_frequencies ENDP

main PROC
	
	push LENGTHOF target
    push OFFSET target
    push OFFSET freqTable
    call Get_frequencies
    add  esp,8

	; display ascii characters and frequencies
	mov  ecx,LENGTHOF freqTable
	mov  esi,0
disp_loop:
	mov  eax,esi
	call WriteChar

	mov  eax,' '
	call WriteChar

	mov  eax,freqTable[esi * TYPE freqTable]
	call WriteDec

	call CrLf

	inc  esi
	loop disp_loop
	


	exit
main ENDP
END main





