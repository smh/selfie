/*
 * Copyright (C) 2024 DiffPlug
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.selfie.kotest

import com.diffplug.selfie.ArrayMap
import com.diffplug.selfie.Snapshot
import com.diffplug.selfie.SnapshotFile

class ConcurrencyStressTest : HarnessKotest() {
  init {
    test("smoke") {
      gradleWriteSS()
      ut_snapshot().assertContent(expectedSnapshot())
      gradleReadSS()
      ut_snapshot().deleteIfExists()
    }
  }
  private fun expectedSnapshot(): String {
    var expectedSnapshots = ArrayMap.empty<String, Snapshot>()
    for (d in 1..1000) {
      expectedSnapshots =
          expectedSnapshots.plus(String.format("test %04d", d), Snapshot.of(d.toString()))
    }
    val snapshotFile = SnapshotFile()
    snapshotFile.snapshots = expectedSnapshots
    val buffer = StringBuilder()
    snapshotFile.serialize(buffer)
    return buffer.toString()
  }
}
