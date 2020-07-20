<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* Need to create a cash register receipt printer.
* It needs to be able to handle different tax rates for different classes of products.
* Needs to print to the console the product totals with tax, tax total and total sale amount.
* Needs to follow proper OOP and OOD principles.
*
*
*
*
<h2>2. Planning the Solution</h2>
* I think about this project as a cash register printing out the receipt with correct info.
* Starting off with a cash register class to handle the main operating of the register
* I'll put the math into a transaction calculator class
* The receipt class will just handle printing the info passed to it to the console
* I don't think the parameters call for a full inventory system, I'll make a product interface and a product class
* 
*
*
<h2>3. Executing the Plan</h2>
* Started with the product class and interface. Set it up so it could just have a new instance 
created at the add to products method in cash register.
* Then created the cash register class and made it a singleton, added the transaction array list
and the add to transaction method. Also the transaction contains method which is only used by the tests right now
, but it could have a place if this project was expanded into a full pos system/inventory system. 
* Made the transaction calculator class, this is where the most unit tests will be. This class will take care of the
 math to add the taxes based on whether the product is tax exempt, imported, both or neither. Will also return the
  total of the transaction. 
* added a process transaction method to cash register to handle calling the tax and passing the needed data to the
 receipt class and call for it to print.
* Wrote the receipt class, it only takes data in and prints the appropriate data to the console.
* Main acts as the buttons of the cash register to add the products to the transaction and then call the process
 transaction method to add the taxes, get the total, print the receipt to the console and clear the transaction array to
  prepare it for the next transaction.
* 
*
*
<h2>4. Reflection / Refactor</h2>
* Made the transaction calculator a singleton
* Pair programmed with Matt and John for most of this project, and Nancy joined us for a good portion of it. It was a
 really good exercise and a lot of fun to work together. Getting to talk out the design really helped all of us think
  through the problem in a OOD mindset and we all got learn from each other as we went along.
* TDD was a little rough at the beginning of this project, trying to learn how to write a test for getters, setters
 and basic methods was really tough to think through. Once I started working on the calculator methods and writing
  the tests for those and then making it pass is really where the benefits of TDD came through. It seems time
   consuming to work through problems this way but putting it into practice really wasn't. Every test was easier to
    write with as the mindset shifted. This was a great exercise, I really enjoyed it and it was really cool to be
     doing an exercise that seems, from the preamble, that it's given to potential employees. 
* 
*
*
*
*