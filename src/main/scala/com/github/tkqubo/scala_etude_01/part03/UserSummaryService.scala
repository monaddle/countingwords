package com.github.tkqubo.scala_etude_01.part03

import java.net.URL

trait UserSummaryService {
  def summarize(url: URL): Seq[UserSummary]
}

