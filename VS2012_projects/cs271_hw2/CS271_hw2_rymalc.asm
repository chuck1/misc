TITLE MASM Template						(main.asm)

INCLUDE Irvine32.inc

PDWORD TYPEDEF PTR DWORD

.data

array DWORD 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15

.code

reverse PROC
	LOCAL parray:DWORD, len:DWORD, halflen:DWORD
    
	
    mov  eax,[ebp + 8]
	mov  parray,eax
	

    mov  eax,[ebp + 12]
	mov  len,eax


	mov  ebx,2
	mov  edx,0
	div  ebx
	mov  halflen,eax


    mov  esi,0
	mov  ecx,halflen

L1: mov edi,len
	sub edi,esi
	sub edi,1
	
	mov  eax,parray

	push [eax + esi * 4]
    push [eax + edi * 4]

    pop  [eax + esi * 4]
    pop  [eax + edi * 4]

	inc  esi

    loop L1

	ret
reverse ENDP

main PROC
    

	push LENGTHOF array
    push OFFSET array
    call reverse
    add  esp,8
    
	mov  esi,OFFSET array
	mov  ecx,LENGTHOF array
	mov  ebx,TYPE array
	call DumpMem

	exit
main ENDP
END main



