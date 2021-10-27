import scala.io.Source.fromResource
// Ici nous créons une classe Tondeuse ayant comme attribut les coordonées x,y ainsi que l'orientation
class Tondeuse(var x:Int, var y:Int, var orientation:String){

  //fonction qui affiche les éléments de la classe tondeuse
  override def toString ="la tondeuse a pour coordonnées ("+x+", "+y+", "+orientation+")"
}


object Run extends App {
  /* La Fonction programmme prend en arguments la tondeuse et les instructions,
  exécutent chaque instruction et retourne les nouvelles coordonnées et orientation de la tondeuse*/

  def programme(tondeuse: Tondeuse, instruction: List[String]): Unit = {

    for (lettre <- instruction) {
      //on verifie ici que les coordonnées de la tondeuse ne sont pas supérieures à celle de la pelouse
      if (tondeuse.x <= pelouse.head || tondeuse.y <= pelouse(1)) {
        if (lettre == "D") {
          tondeuse.orientation match {
            case "N" => tondeuse.orientation = "E"
            case "E" => tondeuse.orientation = "S"
            case "S" => tondeuse.orientation = "W"
            case "W" => tondeuse.orientation = "N"
          }
        }
        else if (lettre == "G") {
          tondeuse.orientation match {
            case "N" => tondeuse.orientation = "W"
            case "E" => tondeuse.orientation = "N"
            case "S" => tondeuse.orientation = "E"
            case "W" => tondeuse.orientation = "S"
          }
        }
        else if (lettre == "A") {
          tondeuse.orientation match {
            case "N" => tondeuse.y = tondeuse.y + 1
            case "E" => tondeuse.x = tondeuse.x + 1
            case "S" => tondeuse.y = tondeuse.y - 1
            case "W" => tondeuse.x = tondeuse.x - 1
          }
        }
      }
    }
    println(tondeuse)
  }

  //On cree une liste de liste nommée fichier qui prend les informations des tondeuses et de la pelouse

  val fichier=List(List(5,5), List(1,2,"N"), List ("G","A","G","A","G","A","G","A","A"), List(3,3,"E"), List("A","A","D","A","A","D","A","D","D","A"))

  // On crée des variables pour récupères chaque liste
  val pelouse = fichier.head.map(_.toString.toInt)//La 1ère liste est la liste des coordonnées de la pelouse qu'on transforme en liste d'entier
  val position1 = fichier(1)      // La 2ème est les coordonnées de la tondeuse 1
  val instruction1 = fichier(2).map(_.toString)   // La 3ème correspond aux instructions de la tondeuse 1
  val position2 = fichier(3)     // La 4ème est les coordonnées de la tondeuse 2
  val instruction2 = fichier(4).map(_.toString) // La 5ème correspond aux instructions de la tondeuse 2

  //On traite les exceptions sur les coordonnées de la pelouse de l'orientation des tondeuses
  assert(pelouse.length==2, "Error: les coordonnées de la pelouse doivent etre x et y séparés par un espace")
  assert(position1(2)=="N" || position1(2)=="S"|| position1(2)=="E"|| position1(2)=="W", "l'orientation de la tondeuse doit etre N,E,S ou W")
  assert(position2(2)=="N" || position2(2)=="S"|| position2(2)=="E"|| position2(2)=="W", "l'orientation de la tondeuse doit etre N,E,S ou W")

  //On traite les exceptions sur les instructions
  for (lettre <-instruction1){
    try {
      lettre match {
        case "A" => true
        case "D" => true
        case "G" => true
      }
    }catch{
      case exception: Exception=>println("Certaines instructions ne sont pas prises en compte.Revoyez les instructions de la tondeuse1. Les lettres à utiliser sont A,D ou G")
    }
  }
  for (lettre <-instruction2){
    try {
      lettre match {
        case "A" => true
        case "D" => true
        case "G" => true
      }
    }catch{
      case exception: Exception=>println("Certaines instructions ne sont pas prises en compte.Revoyez les instructions de la tondeuse2. Les lettres à utiliser sont A,D ou G")
    }
  }

  // On instancie 2 éléments de la classe tondeuse avec les paramètres du fichier
  //Je convertis les coordonnées en Int et les orientations en String
  val Tondeuse1 = new Tondeuse(position1.head.toString.toInt, position1(1).toString.toInt, position1(2).toString)
  val Tondeuse2 = new Tondeuse(position2.head.toString.toInt, position2(1).toString.toInt, position2(2).toString)

  //On exécute les instructions à travers la fonction programme
  val p1= programme(Tondeuse1, instruction1)
  val p2= programme(Tondeuse2, instruction2)
}






