#Read through an array and all the absolute values of each element.
#Stop when you reach last element ( value will be 0 )

#Author: Sau Ma

#Start of Code

.data

	#Array
	Z:.word 5, -4, 60, -12, 45, -2, -10, 5, 0
	sumZ:.word 0
	msg:.asciiz "sumZ equals: "

.text
.globl main

main:

#--------------------------------------Variable Tracker-------------------------

#  $t0 = Address of Z/indexer		
#  $t2 = temp Variable			#  $t3 = SLT var
#  $t4 = Element Value Holder

#  $s0 = Variable for Sum

#--------------------------------------Start of Code---------------------------

	la $t0, Z 	#Load address of Array Z
	li $s0, 0	#s0 = 0	
	lw $t4, 0($t0)  #Load first element of array into variable $t4


Loopy: #Loop through array
	
	move $t2, $t4		#$t2 = $t4
	beqz $t2, Endy		#if( $t2 == 0 ) Branch
	blt $t2, $zero, Pos	#if($t2 < 0) Branch
	add $s0, $t2, $s0	#Add value into Sum Variable
	addi $t0, $t0, 4	#Go to next element of array
	lw $t4, 0($t0)		#Load element into $t4
	j Loopy



Pos: #Make value positive
	
	sub $t2, $0, $t2	#Make  positive [ $t2 = 0 - (-$t2) ]
	add $s0, $t2, $s0	#$s0 = $t2 + $s0
	addi $t0, $t0, 4	#Go to next element of array
	lw $t4, 0($t0)		#Load element into $t4
	j Loopy
	

Endy: #End program
	
	li $v0, 4	#Print String
	la $a0, msg
	syscall

	li $v0, 1	#Print integer value of Sum in $s0
	move $a0, $s0
	syscall
	
	li $v0, 10	#End Program
	syscall