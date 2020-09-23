package com.github.tkqubo.scala_etude_01.part03

import java.net.URL

import com.github.tkqubo.scala_etude_01.part03.Gender.{Female, Male}
import org.scalatest.FunSpec

class UserSummarySummaryServiceImplTest extends FunSpec {
  describe("RandomUserProcessorImpl") {
    it("should convert the input into the list of User instances") {
      // Given
      val url = getClass.getResource("users.json")
      val target = new UserSummaryServiceImpl
      // When
      val actual = target.summarize(url)
      actual.foreach(println)
      // Then
      assert(actual.length === 100)
      val expected = Seq(
        UserSummary("Sem Verweijen", "sem.verweijen@example.com", "NL", Male, new URL("https://randomuser.me/api/portraits/thumb/men/79.jpg")),
        UserSummary("Rasmus Toro", "rasmus.toro@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/72.jpg")),
        UserSummary("Annicka Schakel", "annicka.schakel@example.com", "NL", Female, new URL("https://randomuser.me/api/portraits/thumb/women/23.jpg")),
        UserSummary("Margrit Rey", "margrit.rey@example.com", "CH", Female, new URL("https://randomuser.me/api/portraits/thumb/women/31.jpg")),
        UserSummary("Katie Weaver", "katie.weaver@example.com", "IE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/63.jpg")),
        UserSummary("Lascívia Alves", "lascívia.alves@example.com", "BR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/62.jpg")),
        UserSummary("Emilio Santos", "emilio.santos@example.com", "ES", Male, new URL("https://randomuser.me/api/portraits/thumb/men/8.jpg")),
        UserSummary("Burçin Penninga", "burçin.penninga@example.com", "NL", Female, new URL("https://randomuser.me/api/portraits/thumb/women/72.jpg")),
        UserSummary("Jesse Lopez", "jesse.lopez@example.com", "AU", Male, new URL("https://randomuser.me/api/portraits/thumb/men/58.jpg")),
        UserSummary("Veeti Savela", "veeti.savela@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/74.jpg")),
        UserSummary("Ilhan Klerks", "ilhan.klerks@example.com", "NL", Male, new URL("https://randomuser.me/api/portraits/thumb/men/70.jpg")),
        UserSummary("Robby Schmieder", "robby.schmieder@example.com", "DE", Male, new URL("https://randomuser.me/api/portraits/thumb/men/5.jpg")),
        UserSummary("Dawn Grant", "dawn.grant@example.com", "US", Female, new URL("https://randomuser.me/api/portraits/thumb/women/40.jpg")),
        UserSummary("Marialda Santos", "marialda.santos@example.com", "BR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/22.jpg")),
        UserSummary("Nicole Rohleder", "nicole.rohleder@example.com", "DE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/87.jpg")),
        UserSummary("Cecil Stephens", "cecil.stephens@example.com", "GB", Male, new URL("https://randomuser.me/api/portraits/thumb/men/18.jpg")),
        UserSummary("Juho Walli", "juho.walli@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/21.jpg")),
        UserSummary("Alexander Alvarez", "alexander.alvarez@example.com", "GB", Male, new URL("https://randomuser.me/api/portraits/thumb/men/18.jpg")),
        UserSummary("Celina Watkins", "celina.watkins@example.com", "US", Female, new URL("https://randomuser.me/api/portraits/thumb/women/65.jpg")),
        UserSummary("Charlotte Williamson", "charlotte.williamson@example.com", "GB", Female, new URL("https://randomuser.me/api/portraits/thumb/women/86.jpg")),
        UserSummary("Noélie Bonnet", "noélie.bonnet@example.com", "FR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/96.jpg")),
        UserSummary("Noam Joly", "noam.joly@example.com", "FR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/3.jpg")),
        UserSummary("Emmy Lopez", "emmy.lopez@example.com", "FR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/0.jpg")),
        UserSummary("Martina Helm", "martina.helm@example.com", "DE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/81.jpg")),
        UserSummary("Javier Marin", "javier.marin@example.com", "ES", Male, new URL("https://randomuser.me/api/portraits/thumb/men/27.jpg")),
        UserSummary("Clemens Rousseau", "clemens.rousseau@example.com", "CH", Male, new URL("https://randomuser.me/api/portraits/thumb/men/46.jpg")),
        UserSummary("David Romero", "david.romero@example.com", "ES", Male, new URL("https://randomuser.me/api/portraits/thumb/men/57.jpg")),
        UserSummary("Reinhold Hansen", "reinhold.hansen@example.com", "DE", Male, new URL("https://randomuser.me/api/portraits/thumb/men/34.jpg")),
        UserSummary("Roope Kemppainen", "roope.kemppainen@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/80.jpg")),
        UserSummary("Hugo Nieto", "hugo.nieto@example.com", "ES", Male, new URL("https://randomuser.me/api/portraits/thumb/men/23.jpg")),
        UserSummary("Ashton Chen", "ashton.chen@example.com", "NZ", Male, new URL("https://randomuser.me/api/portraits/thumb/men/58.jpg")),
        UserSummary("Yasemin Taşlı", "yasemin.taşlı@example.com", "TR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/11.jpg")),
        UserSummary("Lisiane Da mata", "lisiane.damata@example.com", "BR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/96.jpg")),
        UserSummary("Sanne Molde", "sanne.molde@example.com", "NO", Female, new URL("https://randomuser.me/api/portraits/thumb/women/61.jpg")),
        UserSummary("Benjamin Simpson", "benjamin.simpson@example.com", "IE", Male, new URL("https://randomuser.me/api/portraits/thumb/men/4.jpg")),
        UserSummary("Julia Ellis", "julia.ellis@example.com", "GB", Female, new URL("https://randomuser.me/api/portraits/thumb/women/93.jpg")),
        UserSummary("Pilar Moreno", "pilar.moreno@example.com", "ES", Female, new URL("https://randomuser.me/api/portraits/thumb/women/72.jpg")),
        UserSummary("Alice Scott", "alice.scott@example.com", "CA", Female, new URL("https://randomuser.me/api/portraits/thumb/women/52.jpg")),
        UserSummary("Aubrey Barnaby", "aubrey.barnaby@example.com", "CA", Female, new URL("https://randomuser.me/api/portraits/thumb/women/51.jpg")),
        UserSummary("Victor Chow", "victor.chow@example.com", "CA", Male, new URL("https://randomuser.me/api/portraits/thumb/men/55.jpg")),
        UserSummary("Lorenzo Gomez", "lorenzo.gomez@example.com", "ES", Male, new URL("https://randomuser.me/api/portraits/thumb/men/33.jpg")),
        UserSummary("Cildo Caldeira", "cildo.caldeira@example.com", "BR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/80.jpg")),
        UserSummary("Maria Ramos", "maria.ramos@example.com", "ES", Female, new URL("https://randomuser.me/api/portraits/thumb/women/45.jpg")),
        UserSummary("تینا زارعی", "تینا.زارعی@example.com", "IR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/85.jpg")),
        UserSummary("Chloe Phillips", "chloe.phillips@example.com", "IE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/85.jpg")),
        UserSummary("Hannah Turner", "hannah.turner@example.com", "NZ", Female, new URL("https://randomuser.me/api/portraits/thumb/women/95.jpg")),
        UserSummary("Alexandra Stone", "alexandra.stone@example.com", "IE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/93.jpg")),
        UserSummary("Todd Bell", "todd.bell@example.com", "IE", Male, new URL("https://randomuser.me/api/portraits/thumb/men/52.jpg")),
        UserSummary("Jimi Tuomi", "jimi.tuomi@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/79.jpg")),
        UserSummary("Ümit Berberoğlu", "ümit.berberoğlu@example.com", "TR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/41.jpg")),
        UserSummary("Anton Kyllonen", "anton.kyllonen@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/20.jpg")),
        UserSummary("Toivo Lampinen", "toivo.lampinen@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/78.jpg")),
        UserSummary("Hannah Scott", "hannah.scott@example.com", "CA", Female, new URL("https://randomuser.me/api/portraits/thumb/women/77.jpg")),
        UserSummary("Emily Hawkins", "emily.hawkins@example.com", "IE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/13.jpg")),
        UserSummary("Barış Çetiner", "barış.çetiner@example.com", "TR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/70.jpg")),
        UserSummary("Amber Bryant", "amber.bryant@example.com", "GB", Female, new URL("https://randomuser.me/api/portraits/thumb/women/76.jpg")),
        UserSummary("Tiffany Weaver", "tiffany.weaver@example.com", "AU", Female, new URL("https://randomuser.me/api/portraits/thumb/women/24.jpg")),
        UserSummary("Cassandre Nguyen", "cassandre.nguyen@example.com", "FR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/71.jpg")),
        UserSummary("Elif Tekelioğlu", "elif.tekelioğlu@example.com", "TR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/75.jpg")),
        UserSummary("Leslie Carter", "leslie.carter@example.com", "US", Male, new URL("https://randomuser.me/api/portraits/thumb/men/54.jpg")),
        UserSummary("Mirella Zuber", "mirella.zuber@example.com", "DE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/44.jpg")),
        UserSummary("Morten Flatmo", "morten.flatmo@example.com", "NO", Male, new URL("https://randomuser.me/api/portraits/thumb/men/69.jpg")),
        UserSummary("Dick Foster", "dick.foster@example.com", "GB", Male, new URL("https://randomuser.me/api/portraits/thumb/men/5.jpg")),
        UserSummary("Herminia Boyd", "herminia.boyd@example.com", "US", Female, new URL("https://randomuser.me/api/portraits/thumb/women/16.jpg")),
        UserSummary("Paulo Fogaça", "paulo.fogaça@example.com", "BR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/94.jpg")),
        UserSummary("Olivia Sims", "olivia.sims@example.com", "GB", Female, new URL("https://randomuser.me/api/portraits/thumb/women/60.jpg")),
        UserSummary("Dorit Schroll", "dorit.schroll@example.com", "DE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/17.jpg")),
        UserSummary("علیرضا کریمی", "علیرضا.کریمی@example.com", "IR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/72.jpg")),
        UserSummary("Rose-marie Kramp", "rose-marie.kramp@example.com", "DE", Female, new URL("https://randomuser.me/api/portraits/thumb/women/42.jpg")),
        UserSummary("Kübra Gümüşpala", "kübra.gümüşpala@example.com", "TR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/55.jpg")),
        UserSummary("Joona Karvonen", "joona.karvonen@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/36.jpg")),
        UserSummary("Ana Jordan", "ana.jordan@example.com", "US", Female, new URL("https://randomuser.me/api/portraits/thumb/women/46.jpg")),
        UserSummary("Isabel Soler", "isabel.soler@example.com", "ES", Female, new URL("https://randomuser.me/api/portraits/thumb/women/69.jpg")),
        UserSummary("Leo Perez", "leo.perez@example.com", "AU", Male, new URL("https://randomuser.me/api/portraits/thumb/men/34.jpg")),
        UserSummary("Thea Martin", "thea.martin@example.com", "NZ", Female, new URL("https://randomuser.me/api/portraits/thumb/women/95.jpg")),
        UserSummary("Montserrat Carmona", "montserrat.carmona@example.com", "ES", Female, new URL("https://randomuser.me/api/portraits/thumb/women/24.jpg")),
        UserSummary("Charlie Abraham", "charlie.abraham@example.com", "CA", Female, new URL("https://randomuser.me/api/portraits/thumb/women/22.jpg")),
        UserSummary("Catalina Lopez", "catalina.lopez@example.com", "ES", Female, new URL("https://randomuser.me/api/portraits/thumb/women/7.jpg")),
        UserSummary("Antonina Tøndel", "antonina.tøndel@example.com", "NO", Female, new URL("https://randomuser.me/api/portraits/thumb/women/13.jpg")),
        UserSummary("Blanca Santana", "blanca.santana@example.com", "ES", Female, new URL("https://randomuser.me/api/portraits/thumb/women/57.jpg")),
        UserSummary("Edmundo Pires", "edmundo.pires@example.com", "BR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/95.jpg")),
        UserSummary("Ava Wilson", "ava.wilson@example.com", "NZ", Female, new URL("https://randomuser.me/api/portraits/thumb/women/93.jpg")),
        UserSummary("Alejandro Fernandez", "alejandro.fernandez@example.com", "ES", Male, new URL("https://randomuser.me/api/portraits/thumb/men/24.jpg")),
        UserSummary("Amalie Christensen", "amalie.christensen@example.com", "DK", Female, new URL("https://randomuser.me/api/portraits/thumb/women/85.jpg")),
        UserSummary("Cameron Walker", "cameron.walker@example.com", "NZ", Male, new URL("https://randomuser.me/api/portraits/thumb/men/35.jpg")),
        UserSummary("Kurt Hill", "kurt.hill@example.com", "IE", Male, new URL("https://randomuser.me/api/portraits/thumb/men/9.jpg")),
        UserSummary("Rachel Blanc", "rachel.blanc@example.com", "CH", Female, new URL("https://randomuser.me/api/portraits/thumb/women/1.jpg")),
        UserSummary("Misty Lewis", "misty.lewis@example.com", "US", Female, new URL("https://randomuser.me/api/portraits/thumb/women/78.jpg")),
        UserSummary("Pearl Oliver", "pearl.oliver@example.com", "AU", Female, new URL("https://randomuser.me/api/portraits/thumb/women/39.jpg")),
        UserSummary("Nicolas Blanco", "nicolas.blanco@example.com", "ES", Male, new URL("https://randomuser.me/api/portraits/thumb/men/81.jpg")),
        UserSummary("Eibertje Schultz", "eibertje.schultz@example.com", "NL", Female, new URL("https://randomuser.me/api/portraits/thumb/women/82.jpg")),
        UserSummary("Caleb Lopez", "caleb.lopez@example.com", "AU", Male, new URL("https://randomuser.me/api/portraits/thumb/men/70.jpg")),
        UserSummary("Mabel Howell", "mabel.howell@example.com", "AU", Female, new URL("https://randomuser.me/api/portraits/thumb/women/76.jpg")),
        UserSummary("Mary Sutton", "mary.sutton@example.com", "GB", Female, new URL("https://randomuser.me/api/portraits/thumb/women/28.jpg")),
        UserSummary("باران صدر", "باران.صدر@example.com", "IR", Female, new URL("https://randomuser.me/api/portraits/thumb/women/30.jpg")),
        UserSummary("Aada Ojala", "aada.ojala@example.com", "FI", Female, new URL("https://randomuser.me/api/portraits/thumb/women/79.jpg")),
        UserSummary("Rose Smith", "rose.smith@example.com", "NZ", Female, new URL("https://randomuser.me/api/portraits/thumb/women/71.jpg")),
        UserSummary("Eino Hokkanen", "eino.hokkanen@example.com", "FI", Male, new URL("https://randomuser.me/api/portraits/thumb/men/68.jpg")),
        UserSummary("Ceyhun Hakyemez", "ceyhun.hakyemez@example.com", "TR", Male, new URL("https://randomuser.me/api/portraits/thumb/men/90.jpg")),
        UserSummary("Jay Brewer", "jay.brewer@example.com", "IE", Male, new URL("https://randomuser.me/api/portraits/thumb/men/40.jpg"))
      )
      assert(actual === expected)
    }
  }
}

object UserSummarySummaryServiceImplTest extends App {
  val target = new UserSummaryServiceImpl
  val result = target.summarize(new URL("https://randomuser.me/api/?results=10"))
  //result.foreach(println)
}
