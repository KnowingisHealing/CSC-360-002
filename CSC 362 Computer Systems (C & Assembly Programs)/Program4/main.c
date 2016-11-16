#include <stdio.h>

void main() {
	int n = 0, s;
	int sum=6, x=3, y=0, denom=2, pair=0;
	// declare your variables in C and initialize them (if you need to)
	__asm { // enter assembly code, from here on, code is assembled, not compiled
		// assembly code here to iterate for sum = 6 to 100	
			top:	cmp		sum, 100
					jg		out
					mov		pair, 0
					mov		x, 3
			top2:	mov		eax, x
					cmp		eax, sum
					jge		out2
					cmp		pair, 0
					jne		out2
					mov		eax, sum
					sub		eax, x
					mov		y, eax
					mov		denom, 2
			top3:	mov		eax, x
					mov		edx, 0		// prepare for division
					div		denom
					cmp		edx, 0
					je		out3
					mov		eax, denom
					cmp		eax, x
					jge		out3
					inc		denom
					jmp		top3
			out3:	mov		eax, denom
					cmp		eax, x
					je		next1
					add		x, 2
			next1:  mov		denom, 2
			top4:	mov		eax, y		// prepare for divison
					mov		edx, 0
					div		denom
					cmp		edx, 0
					je		out4
					mov		eax, denom
					cmp		eax, y
					jge		out4
					inc		denom
					jump	top4
			out4:	mov		eax, denom
					cmp		eax, y
					je		next2
					add		x, 2
					jump	top2
			next2:  mov		pair, 1
		}
	printf("%d = %d + %d\n", sum, x, y);
	__asm {
					jmp		top2
			out2:   mov		eax, x
					cmp		eax, sum
					jl		next3
		}
	printf("No solution found");
	__asm {
					jmp		out	
			next3:	add		sum, 2
					jmp		top
			out:	nop
		}

	printf("%d", s)



		// get the first x (3) and generate the first y (sum – x)
		// have a loop to determine if x is prime by dividing some denominator
		// into x (starting at denominator = 2) until either you find one that
		// divides into x (x is not prime) or denominator reaches x (x is prime)
		// if x is not prime, get next x/y pair (add 2 to x, compute y = sum – x)
		// otherwise determine if y is prime
		// if you find a prime x/y pair, exit assembly code to output this, as in
		// 8 = 3 + 5, return to assembly, increment sum by 2, repeat for loop
		// otherwise if you increment x and it reaches sum, then no x/y pair is
		// found, exit assembly, output no solution found and exit program
	}
	scanf_s("%d", n);
}