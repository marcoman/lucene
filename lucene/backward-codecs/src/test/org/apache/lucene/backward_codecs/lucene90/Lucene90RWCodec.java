/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.lucene.backward_codecs.lucene90;

import org.apache.lucene.codecs.KnnVectorsFormat;
import org.apache.lucene.codecs.PostingsFormat;
import org.apache.lucene.codecs.SegmentInfoFormat;
import org.apache.lucene.codecs.perfield.PerFieldKnnVectorsFormat;

public class Lucene90RWCodec extends Lucene90Codec {

  private final SegmentInfoFormat segmentInfosFormat = new Lucene90RWSegmentInfoFormat();

  private final KnnVectorsFormat defaultKnnVectorsFormat;
  private final KnnVectorsFormat knnVectorsFormat =
      new PerFieldKnnVectorsFormat() {
        @Override
        public KnnVectorsFormat getKnnVectorsFormatForField(String field) {
          return defaultKnnVectorsFormat;
        }
      };
  private final PostingsFormat postingsFormat = new Lucene90RWPostingsFormat();

  public Lucene90RWCodec() {
    this.defaultKnnVectorsFormat =
        new Lucene90RWHnswVectorsFormat(
            Lucene90HnswVectorsFormat.DEFAULT_MAX_CONN,
            Lucene90HnswVectorsFormat.DEFAULT_BEAM_WIDTH);
  }

  @Override
  public KnnVectorsFormat knnVectorsFormat() {
    return knnVectorsFormat;
  }

  @Override
  public SegmentInfoFormat segmentInfoFormat() {
    return segmentInfosFormat;
  }

  @Override
  public PostingsFormat getPostingsFormatForField(String field) {
    return postingsFormat;
  }
}
