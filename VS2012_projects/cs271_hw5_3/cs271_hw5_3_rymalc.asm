TITLE hw_5_3

; Charles Rymal
; CS 271
; Winter 2014
; Homework 5 Prob 3
; 3/3/2014

INCLUDE Irvine32.inc

.data

ARR_SIZE = 65000


array BYTE ARR_SIZE DUP(0)

.code

main PROC

	; current value
	mov   eax,2
outer:	
	mov  bl,array[eax * TYPE array]

	; if marked then increment and continue outer
	cmp  bl,0
	jne  increment
	
	; if reached end of array then break outer
	cmp  eax,ARR_SIZE
	jge  stop

	; initialize inner loop
	mov  esi,eax
	add  esi,eax

inner:
	; if reached end of array then increment and continue outer
	cmp  esi,ARR_SIZE
	jge  increment

	mov  array[esi * TYPE array],1
    
	add  esi,eax
    
	jmp  inner

increment:
	inc  eax
	jmp  outer
stop:
    

	; display all primes
	mov  ecx,ARR_SIZE
	mov  eax,0
disploop:
	mov  bl,array[eax * TYPE array]
	cmp  bl,0
	jne  continue
	
	call WriteDec
	call CrLf

continue:
	inc  eax
	loop disploop
	
	
	
	
	exit
main ENDP
END main

