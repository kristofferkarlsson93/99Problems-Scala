
import scala.collection.immutable.Map

class PotterBook(name: String) {
  def getName: String = name
}

case object PhilosophersStone extends PotterBook("Philosophers stone")

case object ChamberOfSecrets extends PotterBook("Chamber of secrets")

case object PrisonerOfAzkaban extends PotterBook("Prisoner of azkaban")

case object GobletOfFire extends PotterBook("Goblet of fire")

case object OrderOfThePhoenix extends PotterBook("Order of the phenix")

class PotterBookCalculator {

  def countBooks(books: Seq[PotterBook]): Map[PotterBook, Int] = {
    var result = Map.empty[PotterBook, Int]
    books.foreach((book: PotterBook) => {
      result.get(book) match {
        case Some(count: Int) => {
//          result(book) = count += 1
          result += book -> count += 1
        }
        case None => result(book) = 1
      }
    })
    println(result)
    result
  }

  def calculate(books: Seq[PotterBook]): Double = {

    countBooks(books)


//    val bookSets = joinSets(books)
    if (books.length == 2) {
      if (books.distinct.length == 2) (8 * 2) * 0.95
      else 8
    }
    else if (books.length == 3) (8 * 3) * 0.90
    else if (books.length == 4) (8 * 4) * 0.8
    else if (books.length == 5) (8 * 5) * 0.75
    else 8
  }

  def joinSets(books: Seq[PotterBook]) = {
    val set = Set.empty[PotterBook]
    val sets = Seq.empty[Set[PotterBook]]
    books.foreach(book => {
      if (!set.contains(book)) {
        println("book is not in set")
        set + book
        println(set)
      } else {
        println("book is in set")
        sets ++: Set(book)
      }
    })
    println(sets)
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