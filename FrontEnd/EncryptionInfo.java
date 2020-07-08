/*
 * Copyright (C) 2008-2017 Dainippon Screen Mfg. Co., Ltd.
 * CONFIDENTIAL Proprietary to Dainippon Screen Mfg. Co., Ltd.
 *
 * 本プログラムの著作権は大日本スクリーン製造株式会社に帰属するものであり、
 * 同社はこれを営業秘密として管理するものです。従い、本プログラムの全て、
 * 一部にかかわらず、その複製、頒布を行うことは、同社の事前の書面による
 * 承諾がない限り固く禁じられるものです。
 *
 * The copyright of this program shall belong to
 * Dainippon Screen Mfg. Co., Ltd.("SCREEN") as a "work made for hire."
 * Also, SCREEN will treat this program as its trade secret. Accordingly,
 * no one is allowed to copy and/or distribute this program, as a whole or
 * in part, without obtaining SCREEN' prior permission to do so in writing.
 */
package jp.co.screen.equios.job.body.model.impl.xml.job;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import jp.co.screen.equios.job.body.model.base.DataObjectInterface;
import jp.co.screen.equios.job.body.model.base.JobModelConstant;
import jp.co.screen.equios.job.body.model.base.JobModelUtility;
import jp.co.screen.equios.job.body.model.base.UpdateManagerInterface;
import jp.co.screen.swc.util.log.LogMessage;
import jp.co.screen.swc.util.log.LoggerHolder;

/**
 * The Class EncryptionInfo.
 *
 * @author tuyentn.nn
 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
 * @version V3.50EQ001 EQF#D263(EQF#C995) 2020/07/06 loctn.ig
 */
public class EncryptionInfo implements DataObjectInterface{

	/**
	 * The Constant ELEMENT_NAME.
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public static final String ELEMENT_NAME = "EncryptionInfo";
	
	/**
	 * The Constant ATTRIBUTE_NAME_ACSID.
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private static final String ATTRIBUTE_NAME_ACSID = "AcsID";
	
	/**
	 * The Constant ATTRIBUTE_NAME_ACSSUBID.
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private static final String ATTRIBUTE_NAME_ACSSUBID = "AcsSubID";
	
	/**
	 * The Constant ATTRIBUTE_NAME_LIMITPRINTTIME.
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 * @version V3.50EQ001 EQF#D263(EQF#C995) 2020/07/06 loctn.ig
	 */
	private static final String ATTRIBUTE_NAME_LIMITPRINTTIME = "LimitPrintTime";
	
	/**
	 * The Constant ATTRIBUTE_NAME_LIMITDATE.
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private static final String ATTRIBUTE_NAME_LIMITDATE = "LimitDate";
	
	/**
	 * The update manager.
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private UpdateManagerInterface mUpdateManager = null;
	
	/**
	 * ID for accessing encryption data
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private String mAcsID = JobModelConstant.BLANK;
	
	/**
	 * SubID for accessing encryption data
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private String mAcsSubID = JobModelConstant.BLANK;
	
	/**
	 * Printing times upper limit ("-1" means no limit)
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private Long mLimitPrintTime = JobModelConstant.DEFAULT_LIMITPRINTTIME;
	
	/**
	 * Printing possible limit date (due date) ("" means no date limit)
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private Long mLimitDate = JobModelConstant.DEFAULT_LIMITDATE;
	
	/**
	 * Instantiates a new encryption info.
	 *
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public EncryptionInfo(){
		
	}
	
	/**
	 * Instantiates a new encryption info.
	 *
	 * @param inUpdateManager
	 *            the update manager
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public EncryptionInfo(UpdateManagerInterface inUpdateManager){
		mUpdateManager = inUpdateManager;
	}
	
	/**
	 * Sets the acs ID base.
	 *
	 * @param inAcsID
	 *            the new acs ID base
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private void setAcsIDBase(String inAcsID){
		mAcsID = inAcsID;
	}
	
	/**
	 * Sets the acs ID.
	 *
	 * @param inAcsID
	 *            the new acs ID
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public void setAcsID(String inAcsID){
		setAcsIDBase(inAcsID);
		mUpdateManager.setIsUpdate(true);
	}
	
	/**
	 * Gets the acs ID.
	 *
	 * @return the acs ID
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public String getAcsID(){
		return mAcsID;
	}
	
	/**
	 * Sets the acs sub ID base.
	 *
	 * @param inAcsSubID
	 *            the new acs sub ID base
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private void setAcsSubIDBase(String inAcsSubID){
		mAcsSubID = inAcsSubID;
	}
	
	/**
	 * Sets the acs sub ID.
	 *
	 * @param inAcsSubID
	 *            the new acs sub ID
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public void setAcsSubID(String inAcsSubID){
		setAcsSubIDBase(inAcsSubID);
		mUpdateManager.setIsUpdate(true);
	}
	
	/**
	 * Gets the acs sub ID.
	 *
	 * @return the acs sub ID
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public String getAcsSubID(){
		return mAcsSubID;
	}
	
	/**
	 * Sets the limit print time base.
	 *
	 * @param inLimitPrintTime
	 *            the new limit print time base
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private void setLimitPrintTimeBase(Long inLimitPrintTime){
		mLimitPrintTime = inLimitPrintTime;
	}
	
	/**
	 * Sets the limit print time.
	 *
	 * @param inLimitPrintTime
	 *            the new limit print time
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public void setLimitPrintTime(Long inLimitPrintTime){
		setLimitPrintTimeBase(inLimitPrintTime);
		mUpdateManager.setIsUpdate(true);
	}
	
	/**
	 * Gets the limit print time.
	 *
	 * @return the limit print time
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public Long getLimitPrintTime(){
		return mLimitPrintTime;
	}
	
	/**
	 * Sets the limit date base.
	 *
	 * @param inLimitDate
	 *            the new limit date base
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	private void setLimitDateBase(Long inLimitDate){
		mLimitDate = inLimitDate;
	}
	
	/**
	 * Sets the limit date.
	 *
	 * @param inLimitDate
	 *            the new limit date
	 * @author tuyentn.nn
	 * @since [V2.30 EQ007] EQF#C995 (Jun 5, 2017)
	 */
	public void setLimitDate(Long inLimitDate){
		setLimitDateBase(inLimitDate);
		mUpdateManager.setIsUpdate(true);
	}
	
	public Long getLimitDate(){
		return mLimitDate;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void parseElement(Properties _Properties) {
		setAcsIDBase(_Properties.getProperty(ATTRIBUTE_NAME_ACSID));
		setAcsSubIDBase(_Properties.getProperty(ATTRIBUTE_NAME_ACSSUBID));
		String limitPrintTime = _Properties.getProperty(ATTRIBUTE_NAME_LIMITPRINTTIME);
		// ↓EDIT [EQUIOS V2.5] EQF#C995 trunglp (Feb 13, 2019)
		// According to the feedback of Q&A004, we had update condition check NULL for limitPrintTime & limitDate
		// if(!StringUtils.isEmpty(limitPrintTime)){
		if(limitPrintTime != null && !limitPrintTime.equals("")) {
			setLimitPrintTimeBase(Long.valueOf(limitPrintTime));
		}
		String limitDate = _Properties.getProperty(ATTRIBUTE_NAME_LIMITDATE);
		// if(!StringUtils.isEmpty(limitDate)){
		if(limitDate != null && !limitDate.equals("")) {
			setLimitDateBase(Long.valueOf(limitDate));
		}
		// ↑EDIT [EQUIOS V2.5] EQF#C995 trunglp (Feb 13, 2019)
	}

	/**
	 * {@inheritDoc}
	 */
	public String makeTextElement() throws IOException {
		Writer writer = new StringWriter();
		try {
			makeTextElement(writer);
		} catch (IOException e) {
				e.printStackTrace();
			LoggerHolder.getLogger().error(new LogMessage("IOException", "makeTextElement", ELEMENT_NAME));
			throw e;
		}
		return writer.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	public void makeTextElement(Writer _writer) throws IOException {
		Properties properties = new Properties();
		
		properties.setProperty(ATTRIBUTE_NAME_ACSID, mAcsID);
		properties.setProperty(ATTRIBUTE_NAME_ACSSUBID, mAcsSubID);
		if(mLimitPrintTime != null){
			properties.setProperty(ATTRIBUTE_NAME_LIMITPRINTTIME, String.valueOf(mLimitPrintTime));
		}
		if(mLimitDate != null){
			properties.setProperty(ATTRIBUTE_NAME_LIMITDATE, String.valueOf(mLimitDate));
		}
		
		String[] elementString = JobModelUtility.createElementString(ELEMENT_NAME, properties, false);
		try{
			_writer.write(elementString[0]);
		}catch(IOException e){
			e.printStackTrace();
			LoggerHolder.getLogger().error(new LogMessage("IOException：writing Writer failed", "makeTextElement(Writer)", ELEMENT_NAME));
			throw e;	
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void appendChild(DataObjectInterface _child) {
		
	}

}
