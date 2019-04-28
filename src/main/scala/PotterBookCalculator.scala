
import scala.collection.mutable

class PotterBook(name: String) {
  def getName: String = name
}

case object PhilosophersStone extends PotterBook("Philosophers stone")

case object ChamberOfSecrets extends PotterBook("Chamber of secrets")

case object PrisonerOfAzkaban extends PotterBook("Prisoner of azkaban")

case object GobletOfFire extends PotterBook("Goblet of fire")

case object OrderOfThePhoenix extends PotterBook("Order of the phenix")

class PotterBookCalculator {

  def calculate(books: Seq[PotterBook]): Double = {
    val countedBooks = countBooks(books)
    val bookSets = pairSets(countedBooks)

    bookSets.map(getPriceForSet).sum
  }

  private def countBooks(books: Seq[PotterBook]): mutable.Map[PotterBook, Int] = {
    val result = mutable.Map.empty[PotterBook, Int]
    books.foreach((book: PotterBook) => {
      result.get(book) match {
        case Some(count: Int) => result(book) = count + 1
        case None => result(book) = 1
      }
    })
    result
  }

  private def pairSets(purchase: mutable.Map[PotterBook, Int]): Seq[mutable.Set[PotterBook]] = {
    val numberOfSets: Int = purchase.maxBy(_._2)._2

    var result = Seq.empty[mutable.Set[PotterBook]]
    for (_ <- 0 until numberOfSets) {
      val currentSet = mutable.Set.empty[PotterBook]
      purchase.foreach {
        case (potterBook: PotterBook, numberOf: Int) => {
          if (numberOf > 0 && !currentSet(potterBook)) {
            currentSet += potterBook
            purchase(potterBook) = numberOf - 1
          }
        }
      }
      result = result :+ currentSet
    }
    result
  }

  private def getPriceForSet: mutable.Set[PotterBook] => Double = {
    set: mutable.Set[PotterBook] => {
      if (set.size == 2) {
        (8 * 2) * 0.95
      }
      else if (set.size == 3) (8 * 3) * 0.90
      else if (set.size == 4) (8 * 4) * 0.8
      else if (set.size == 5) (8 * 5) * 0.75
      else 8
    }
  }
}


/*
The potter book calculator kata
1 book 8 euro
2 books 5 % discount
3 books 10 % discount
4 books 20 % discount
5 books % 25 percent discount
the discount is only valid for sets of books. Buying 2 of one book is not valid.
But buying 2 of each book is 2 sets = valid
 */