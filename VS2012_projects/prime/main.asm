TITLE MASM Template						(main.asm)

; CS 271
; W 2014
; Assignment 1
; Charles Rymal

INCLUDE Irvine32.inc
.data

NUM_PRIMES = 10000
primes DWORD NUM_PRIMES dup (?)

.code

main PROC
	; ebp	number of interest
	; ebx	offset of next location in primes array
	; esp   end of primes array

	; ecx	iterator for offset in primes

	mov  ebp,2
	mov  ebx,OFFSET primes


L1:
	; number is prime
	; display and write to array
	mov  eax,ebp
	call WriteDec
	call Crlf

	mov  [ebx],ebp
	add  ebx,SIZEOF(DWORD)
	
	cmp  ebx,OFFSET primes + SIZEOF(DWORD) * NUM_PRIMES
	je   L4
L2:
	inc  ebp

	mov  ecx,OFFSET primes
L3:
	mov  edx,0
	mov  eax,ebp
	div  DWORD PTR [ecx]

	; if mod is 0, ebp is not prime
	cmp  edx,0
	je   L2

	; if [ecx] squared is greater than ebp, ebp is prime
	mov  eax,DWORD PTR [ecx]
	mul  eax
	cmp  eax,ebp
	jg   L1
	
	; increment
	add  ecx,SIZEOF(DWORD)
	
	; if end of array is reached (should never occur), ebp is prime
	cmp  ecx,ebx
	je   L1		; is prime

	; loop
	jmp  L3

L4:

	exit
main ENDP

END main



