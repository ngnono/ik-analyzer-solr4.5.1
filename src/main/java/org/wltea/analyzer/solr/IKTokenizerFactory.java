/**
 * IK 中文分词  版本 5.0
 * IK Analyzer release 5.0
 * 
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
 *
 * 源代码由林良益(linliangyi2005@gmail.com)提供
 * 版权声明 2012，乌龙茶工作室
 * provided by Linliangyi and copyright 2012 by Oolong studio
 * 
 * 
 */
package org.wltea.analyzer.solr;

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource;
import org.wltea.analyzer.lucene.IKTokenizer;

/**
 * IK中文分词
 * Solr分词器工厂实现
 * 
 * 2012-3-6
 *
 */
public class IKTokenizerFactory extends TokenizerFactory {


    public IKTokenizerFactory(Map<String, String> args) {
        super(args);
        assureMatchVersion();
        useSmart = getBoolean(args, "useSmart", false);
    }

    private boolean useSmart;


    public void init(Map<String, String> args) {

        assureMatchVersion();
    }



    @Override
    public Tokenizer create(AttributeSource.AttributeFactory attributeFactory, Reader input) {
        IKTokenizer ikTokenizer = new IKTokenizer(input, useSmart);
        return ikTokenizer;
    }
	
//	private boolean useSmart = false;
//
//    @Override
//    public void init(Map<String, String> params) {
//        super.init(params);
//        String useSmartParam = params.get("useSmart");
//        this.useSmart = (useSmartParam != null ? Boolean.parseBoolean(useSmartParam) : false);
//    }
//
//	/* (non-Javadoc)
//	 * @see org.apache.solr.analysis.TokenizerFactory#create(java.io.Reader)
//	 */
//	public Tokenizer create(Reader in) {
//		return new IKTokenizer(in , this.useSmart);
//	}

}
