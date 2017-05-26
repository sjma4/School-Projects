#Search through array to count how many values are divisible by 4
#Count number of ones in the binary number of numbers divisible by 4
#Counter for number of 1s in the decimal value for the counter of numbers divisible by 4

#Author: Sau Ma

#Start

.data
	#Create new line to make things purty
	newLine:.asciiz "\n"

	#Part A
	X:.word 5, 4, 8, 12, 13, 16, 18, 20, 24, 23, 0
	msg:.asciiz "Number of values divisible by 4 = "

	#Part B
	msg2:.asciiz "Number of 1's in the Binary Number = "

	#Part C
	Z:.half -1, 9, -3, 5, 4, 7, 0
	msg3:.asciiz "Sum of array Z: "

.text
.globl main

main:

#---------------------------------Variable Tracker---------------------------------

#  $t0 = Address of X/Array Indexer	#  $t1 = Element value holder for ArrayX

#  $t2 = Temp variable for X		#  $t3 = Temp var for bit checking

#  $s0 = mask				#  $s1 = bit counter for mask

#  $s2 = Counter for # divisible by 4	#  $s3 = counter for 1's in Binary Number of $s2

#  $s4 = constant 32			#  $t4 = Address of Z/Array Indexer

#  $t5 = Temp Variable for Z 		#  $t6 = Element value holder for ArrayZ

#  $s5 = Sum for arrayZ			#  $t7 = Variable to hold -1 for multiplication

#  $t8 = value to store abs

#-------------------------------- Start of Code ------------------------------------
#-------------------------------- Variable Setup -----------------------------------


	la $t0, X	#Load address of Array X
	la $t4, Z	#Load address of Array Z
	li $s2, 0	#Set Counter to 0
	li $s3, 0 	#Set num of 1's = 0
	li $s0, 1	#Set mask = 1
	li $s1, 0	#Set mask bit counter = 0
	li $t3, 0	#Set $t3 to 0
	li $s4, 8	#$s4 = 32
	lw $t1, 0($t0)	#Load first element of arrayX into $t1
	lh $t6, 0($t4)  #Load first element of arrayZ into $t6
	li $s5, 0 	#Set Sum variable to 0
	li $t8, 0	#Set value to 0

#----------------------------- Start of Part C ------------------------------------

LoopyZ: #Loop through array Z

	move $t5, $t6		#$t5 = $t6
	beqz $t5, StoreIt	#if ($t5 = 0) Branch to StoreIt
	blt  $t5, 0, AbsV	#if ($t5 < 0) Branch and find abs value
	add $s5, $s5, $t5	#Compute sum when number is positive
	addi $t4, $t4, 2	#Go to next element of arrayZ 
	lh $t6, 0($t4)		#Get value
	j LoopyZ


AbsV: #Find absolute Value
        
	abs $t8, $t5 		#Make negative value positive
	add $s5, $s5, $t8	#Compute sum of values
	addi $t4, $t4, 2	#Go to next element of arrayZ
	lh $t6, 0($t4)		#Get value
	j LoopyZ		#Jump back to LoopyZ

StoreIt: #Store Value of Sum
	
	sh $s5, 0($t4)		#Store Sum into memory
	j LoopyX		#Jump to Part A/B

#------------------------------ End of Part C ------------------------------------
#------------------------------ Start of Part A/B --------------------------------

LoopyX: #Loop through array X

	move $t2, $t1		#$t2 = $t1
	beqz $t2, Bits		#if ($t2 = 0) Branch
	andi $t2, $t2, 3	#Mask value to test if $t2%4 = 0
	beq $t2, 0, County	#if ($t2 == 0) Branch
	addi $t0, $t0, 4	#Go to next element of arrayX
	lw $t1, 0($t0)		#Get value
	j LoopyX


County: #Counter for number of values divisible by 4

	addi $s2, $s2, 1	#Increment Counter
	addi $t0, $t0, 4	#Go to next element
	lw $t1, 0($t0)		#Get value
	j LoopyX

Bits: #Counter for num of ones

	and $t3, $s2, $s0	#$t3 = $s2 & $s0
	beqz $t3, NoCount	#if ($t3 = 0) Branch
	addi $s3, $s3, 1	#Increment bit counter
	mul $s0, $s0, 2		#Shift bit of mask left
	addi $s1, $s1, 1	#Increment mask bit counter
	bgt $s1, $s4, Endy	#If ($s1 > 32) Branch
	j Bits

NoCount: #no increment

	mul $s0, $s0, 2		#Shift bit of mask
	addi $s1, $s1, 1	#Increment mask counter
	bgt $s1, $s4, Endy	#If ($s1 > 32) Branch
	j Bits

#------------------------------- End of Part A/B ------------------------------------
#------------------------------- Print Results --------------------------------------

Endy: #End of Program

	li $v0, 4		#Print first message
	la $a0, msg
	syscall

	li $v0, 1		#Print counter
	move $a0, $s2
	syscall

	la $a0, newLine		#Print new line
	addi $v0, $0, 4
	syscall

	li $v0, 4		#Print 2nd message
	la $a0, msg2
	syscall

	la $v0, 1		#Print number of bits
	move $a0, $s3
	syscall

	la $a0, newLine		#Print new line
	addi $v0, $0, 4
	syscall

	li $v0, 4		#Print 3rd message
	la $a0, msg3
	syscall

	la $v0, 1		#Print Sum
	move $a0, $s5
	syscall

	la $a0, newLine		#Print new line
	addi $v0, $0, 4
	syscall
	
	li $v0, 10		#End program
	syscall














