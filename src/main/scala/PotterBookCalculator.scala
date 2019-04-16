
class PotterBook(name: String)

case object PhilosophersStone extends PotterBook("Philosophers stone")

case object ChamberOfSecrets extends PotterBook("Chamber of secrets")

case object PrisonerOfAzkaban extends PotterBook("Prisoner of azkaban")

case object GobletOfFire extends PotterBook("Goblet of fire")

case object OrderOfThePhenix extends PotterBook("Order of the phenix")

class PotterBookCalculator {

  def calculate(books: Seq[PotterBook]): Double = {

    if (books.length == 2) {
      if (books.distinct.length == 2)  (8 * 2) * 0.95
      else 8
    }
    else if (books.length == 3) (8 * 3) * 0.90
    else if (books.length == 4) (8 * 4) * 0.8
    else if (books.length == 5) (8 * 5) * 0.75
    else 8
  }

}


/*
The potter book calculator kata
1 book 8 kr
2 books 5 % discount
3 books 10 % discount
4 books 20 % discount
5 books % 25 percent discount

the discount is only valid for sets of books. Buying 2 of one book is not valid
 */