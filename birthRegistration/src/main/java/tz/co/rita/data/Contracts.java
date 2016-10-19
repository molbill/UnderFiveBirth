/*
 * Copyright (C) 2015 UNICEF Tanzania.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tz.co.rita.data;

import android.net.Uri;
import android.provider.BaseColumns;

public class Contracts {

	public static final String TAG = Contracts.class.getSimpleName();

	/**
	 * Defines the string for the database name
	 */
	public static final String DB_NAME = "birthregistration.db";

	/**
	 * Defines the integer for the database version
	 */
	public static final int DB_VERSION = 3;

	/**
	 * Define component strings used in table creation strings
	 */
	private static final String TEXT_TYPE = " TEXT";
	private static final String INTEGER_TYPE = " INTEGER";
	private static final String LONG_TYPE = " LONG";
	// private static final String DOUBLE_TYPE = " DOUBLE";
	// private static final String FLOAT_TYPE = " FLOAT";
	private static final String PRIMARY_KEY = " PRIMARY KEY";
	private static final String COMMA_SEP = ",";
	private static final String NO_CASE = " COLLATE NOCASE";
	/**
	 * Defines the string for the SQL statement for creating the BirthRecord
	 * table
	 */
	public static final String SQL_CREATE_BIRTH_RECORD_TABLE = "CREATE TABLE "
			+ Contracts.BirthRecord.TABLE_NAME + "( " 
			+ Contracts.BirthRecord.COLUMN_NAME_BIRTH_RECORD_ID + INTEGER_TYPE + PRIMARY_KEY + COMMA_SEP
			+ Contracts.BirthRecord.COLUMN_NAME_FORM_NUMBER + TEXT_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_FIRST_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_SECOND_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_SEX + INTEGER_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_BIRTH_DATE + TEXT_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_BIRTH_PLACE + INTEGER_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_BIRTH_PLACE_DISTRICT_CODE + TEXT_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_STATE_AT_BIRTH + INTEGER_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_TYPE_OF_BIRTH + INTEGER_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CHILD_RESIDENCE_POST_CODE + TEXT_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_MOTHER_FIRST_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_MOTHER_SECOND_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_MOTHER_LAST_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_MOTHER_COUNTRY_OF_BIRTH + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_MOTHER_DISTRICT_CODE + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_MOTHER_NUMBER_OF_CHILDREN + TEXT_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_MOTHER_AGE + TEXT_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FATHER_FIRST_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FATHER_SECOND_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FATHER_LAST_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FATHER_COUNTRY_OF_BIRTH + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FATHER_DISTRICT_CODE + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FILLED_BY + INTEGER_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FILLED_BY_FIRST_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_FILLED_BY_LAST_NAME + TEXT_TYPE + NO_CASE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_REGISTRATION_CENTER_CODE + TEXT_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_CERTIFICATE_ISSUED + INTEGER_TYPE + COMMA_SEP 
			+ Contracts.BirthRecord.COLUMN_NAME_DATE_OF_REGISTRATION + TEXT_TYPE  + COMMA_SEP
			+ Contracts.BirthRecord.COLUMN_NAME_IMAGE_FILE_PATH + TEXT_TYPE + COMMA_SEP
			+ Contracts.BirthRecord.COLUMN_NAME_UPLOAD_STATUS + INTEGER_TYPE
			+ ")";

	/**
	 * Defines the string used in the SQL statement for deleting the BirthRecord
	 * table
	 */
	public static final String SQL_DELETE_BIRTH_RECORD_TABLE = "DROP TABLE IF EXISTS "
			+ Contracts.BirthRecord.TABLE_NAME;

	public static abstract class BirthRecord implements BaseColumns {
		public static final Uri CONTENT_URI = Uri
				.parse("content://tz.co.rita.birthregistration.birthregistrationprovider/birthrecord");
		public static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.rita.birthregistration.birthrecord";
		public static final String MULTIPLE_RECORDS_MIME_TYPE = "vnd.android.cursor.dir/rita.birthregistration.mbirthrecord";
		public static final String TABLE_NAME = "birthrecord";
		public static final String COLUMN_NAME_BIRTH_RECORD_ID = "_id";
		public static final String COLUMN_NAME_FORM_NUMBER = "form_number";
		public static final String COLUMN_NAME_CHILD_FIRST_NAME = "child_first_name";
		public static final String COLUMN_NAME_CHILD_SECOND_NAME = "child_second_name";
		public static final String COLUMN_NAME_CHILD_SEX = "child_sex";
		public static final String COLUMN_NAME_CHILD_BIRTH_DATE = "child_birth_date";
		public static final String COLUMN_NAME_CHILD_BIRTH_PLACE = "child_birth_place";
		public static final String COLUMN_NAME_CHILD_BIRTH_PLACE_DISTRICT_CODE = "child_birth_place_distrrict_code";
		public static final String COLUMN_NAME_CHILD_STATE_AT_BIRTH = "child_state_at_birth";
		public static final String COLUMN_NAME_CHILD_TYPE_OF_BIRTH = "child_type_of_birth";
		public static final String COLUMN_NAME_CHILD_RESIDENCE_POST_CODE = "child_residence_post_code";
		public static final String COLUMN_NAME_MOTHER_FIRST_NAME = "mother_first_name";
		public static final String COLUMN_NAME_MOTHER_SECOND_NAME = "mother_second_name";
		public static final String COLUMN_NAME_MOTHER_LAST_NAME = "mother_last_name";
		public static final String COLUMN_NAME_MOTHER_COUNTRY_OF_BIRTH = "mother_country_of_birth";
		public static final String COLUMN_NAME_MOTHER_DISTRICT_CODE = "mother_district_code";
		public static final String COLUMN_NAME_MOTHER_NUMBER_OF_CHILDREN = "mother_number_of_children";
		public static final String COLUMN_NAME_MOTHER_AGE = "mother_age";
		public static final String COLUMN_NAME_FATHER_FIRST_NAME = "father_first_name";
		public static final String COLUMN_NAME_FATHER_SECOND_NAME = "father_second_name";
		public static final String COLUMN_NAME_FATHER_LAST_NAME = "father_last_name";
		public static final String COLUMN_NAME_FATHER_COUNTRY_OF_BIRTH = "father_country_of_birth";
		public static final String COLUMN_NAME_FATHER_DISTRICT_CODE = "father_district_code";
		public static final String COLUMN_NAME_FILLED_BY = "filled_by";
		public static final String COLUMN_NAME_FILLED_BY_FIRST_NAME = "filled_by_first_name";
		public static final String COLUMN_NAME_FILLED_BY_LAST_NAME = "filled_by_last_name";
		public static final String COLUMN_NAME_REGISTRATION_CENTER_CODE = "registration_center_code";
		public static final String COLUMN_NAME_CERTIFICATE_ISSUED = "certificate_issued";
		public static final String COLUMN_NAME_DATE_OF_REGISTRATION = "date_of_registration";
		public static final String COLUMN_NAME_IMAGE_FILE_PATH = "image_file_path";
		public static final String COLUMN_NAME_UPLOAD_STATUS = "upload_status";

	}

	/*
	 * COUNTRY CODES TABLE
	 */

	public static final String SQL_CREATE_COUNTRY_TABLE = "CREATE TABLE "
			+ Contracts.Country.TABLE_NAME + "( " + Contracts.Country.COLUMN_NAME_COUNTRY_ID + INTEGER_TYPE
			+ PRIMARY_KEY + COMMA_SEP
			+ Contracts.Country.COLUMN_NAME_COUNTRY_NAME + TEXT_TYPE + NO_CASE
			+ COMMA_SEP + Contracts.Country.COLUMN_NAME_COUNTRY_CODE
			+ TEXT_TYPE + NO_CASE + ");";

	/**
	 * Defines the string used in the SQL statement for deleting the BirthRecord
	 * table
	 */
	public static final String SQL_DELETE_COUNTRY_TABLE = "DROP TABLE IF EXISTS "
			+ Contracts.Country.TABLE_NAME;

	public static abstract class Country implements BaseColumns {
		public static final Uri CONTENT_URI = Uri
				.parse("content://tz.co.rita.birthregistration.birthregistrationprovider/country");
		public static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.rita.birthregistration.country";
		public static final String MULTIPLE_RECORDS_MIME_TYPE = "vnd.android.cursor.dir/rita.birthregistration.mcountry";
		public static final String TABLE_NAME = "country";
		public static final String COLUMN_NAME_COUNTRY_ID = "_id";
		public static final String COLUMN_NAME_COUNTRY_CODE = "country_code";
		public static final String COLUMN_NAME_COUNTRY_NAME = "country_name";

	}

	public static final String SQL_POPULATE_COUNTRY_TABLE = 			
			"INSERT INTO Country (country_code, country_name) VALUES "
					+ "('TZA', 'TANZANIA, UNITED REPUBLIC OF'),"
					+ "('AFG', 'AFGHANISTAN'),"
					+ "('ALB', 'ALBANIA'),"
					+ "('DZA', 'ALGERIA'),"
					+ "('ASM', 'AMERICAN SAMOA'),"
					+ "('AND', 'ANDORRA'),"
					+ "('AGO', 'ANGOLA'),"
					+ "('AIA', 'ANGUILLA'),"
					+ "('ATA', 'ANTARCTICA')," 
					+ "('ATG', 'ANTIGUA AND BARBUDA'),"
					+ "('ARG', 'ARGENTINA'),"
					+ "('ARM', 'ARMENIA'),"
					+ "('ABW', 'ARUBA'),"
					+ "('AUS', 'AUSTRALIA'),"
					+ "('AUT', 'AUSTRIA'),"
					+ "('AZE', 'AZERBAIJAN'),"
					+ "('BHS', 'BAHAMAS'),"
					+ "('BHR', 'BAHRAIN'),"
					+ "('BGD', 'BANGLADESH'),"
					+ "('BRB', 'BARBADOS'),"
					+ "('BLR', 'BELARUS'),"
					+ "('BEL', 'BELGIUM'),"
					+ "('BLZ', 'BELIZE'),"
					+ "('BEN', 'BENIN'),"
					+ "('BMU', 'BERMUDA'),"
					+ "('BTN', 'BHUTAN'),"
					+ "('BOL', 'BOLIVIA'),"
					+ "('BIH', 'BOSNIA AND HERZEGOWINA'),"
					+ "('BWA', 'BOTSWANA'),"
					+ "('BVT', 'BOUVET ISLAND (Norway)'),"
					+ "('BRA', 'BRAZIL'),"
					+ "('IOT', 'BRITISH INDIAN OCEAN TERRITORY'),"
					+ "('BRN', 'BRUNEI DARUSSALAM'),"
					+ "('BGR', 'BULGARIA'),"
					+ "('BFA', 'BURKINA FASO'),"
					+ "('BDI', 'BURUNDI'),"
					+ "('KHM', 'CAMBODIA'),"
					+ "('CMR', 'CAMEROON'),"
					+ "('CAN', 'CANADA'),"
					+ "('CPV', 'CAPE VERDE'),"
					+ "('CYM', 'CAYMAN ISLANDS'),"
					+ "('CAF', 'CENTRAL AFRICAN REPUBLIC'),"
					+ "('TCD', 'CHAD'),"
					+ "('CHL', 'CHILE'),"
					+ "('CHN', 'CHINA'),"
					+ "('CXR', 'CHRISTMAS ISLAND'),"
					+ "('CCK', 'COCOS ISLANDS - Austrailia'),"
					+ "('COL', 'COLOMBIA'),"
					+ "('COM', 'COMOROS'),"
					+ "('COG', 'CONGO'),"
					+ "('COD', 'CONGO, THE DRC'),"
					+ "('COK', 'COOK ISLANDS'),"
					+ "('CRI', 'COSTA RICA'),"
					+ "('CIV', 'IVORY COAST'),"
					+ "('HRV', 'CROATIA'),"
					+ "('CUB', 'CUBA'),"
					+ "('CYP', 'CYPRUS'),"
					+ "('CZE', 'CZECH REPUBLIC'),"
					+ "('DNK', 'DENMARK'),"
					+ "('DJI', 'DJIBOUTI'),"
					+ "('DMA', 'DOMINICA'),"
					+ "('DOM', 'DOMINICAN REPUBLIC'),"
					+ "('TMP', 'EAST TIMOR'),"
					+ "('ECU', 'ECUADOR'),"
					+ "('EGY', 'EGYPT'),"
					+ "('SLV', 'EL SALVADOR'),"
					+ "('GNQ', 'EQUATORIAL GUINEA'),"
					+ "('ERI', 'ERITREA'),"
					+ "('EST', 'ESTONIA'),"
					+ "('ETH', 'ETHIOPIA'),"
					+ "('FLK', 'FALKLAND ISLANDS'),"
					+ "('FRO', 'FAROE ISLANDS'),"
					+ "('FJI', 'FIJI'),"
					+ "('FIN', 'FINLAND'),"
					+ "('FRA', 'FRANCE'),"
					+ "('FXX', 'FRANCE, METROPOLITAN'),"
					+ "('GUF', 'FRENCH GUIANA'),"
					+ "('PYF', 'FRENCH POLYNESIA'),"
					+ "('ATF', 'FRENCH SOUTHERN TERRITORIES'),"
					+ "('GAB', 'GABON'),"
					+ "('GMB', 'GAMBIA'),"
					+ "('GEO', 'GEORGIA'),"
					+ "('DEU', 'GERMANY'),"
					+ "('GHA', 'GHANA'),"
					+ "('GIB', 'GIBRALTAR'),"
					+ "('GRC', 'GREECE'),"
					+ "('GRL', 'GREENLAND'),"
					+ "('GRD', 'GRENADA'),"
					+ "('GLP', 'GUADELOUPE'),"
					+ "('GUM', 'GUAM'),"
					+ "('GTM', 'GUATEMALA'),"
					+ "('GIN', 'GUINEA'),"
					+ "('GNB', 'GUINEA-BISSAU'),"
					+ "('GUY', 'GUYANA'),"
					+ "('HTI', 'HAITI'),"
					+ "('HMD', 'HEARD AND MC DONALD ISLANDS'),"
					+ "('VAT', 'VATICAN CITY STATE'),"
					+ "('HND', 'HONDURAS'),"
					+ "('HKG', 'HONG KONG'),"
					+ "('HUN', 'HUNGARY'),"
					+ "('ISL', 'ICELAND'),"
					+ "('IND', 'INDIA'),"
					+ "('IDN', 'INDONESIA'),"
					+ "('IRN', 'IRAN'),"
					+ "('IRQ', 'IRAQ'),"
					+ "('IRL', 'IRELAND'),"
					+ "('ISR', 'ISRAEL'),"
					+ "('ITA', 'ITALY'),"
					+ "('JAM', 'JAMAICA'),"
					+ "('JPN', 'JAPAN'),"
					+ "('JOR', 'JORDAN'),"
					+ "('KAZ', 'KAZAKHSTAN'),"
					+ "('KEN', 'KENYA'),"
					+ "('KIR', 'KIRIBATI'),"
					+ "('PRK', 'NORTH KOREA'),"
					+ "('KOR', 'SOUTH KOREA'),"
					+ "('KWT', 'KUWAIT'),"
					+ "('KGZ', 'KYRGYZSTAN'),"
					+ "('LAO', 'LAOS'),"
					+ "('LVA', 'LATVIA'),"
					+ "('LBN', 'LEBANON'),"
					+ "('LSO', 'LESOTHO'),"
					+ "('LBR', 'LIBERIA'),"
					+ "('LBY', 'LIBYAN ARAB JAMAHIRIYA'),"
					+ "('LIE', 'LIECHTENSTEIN'),"
					+ "('LTU', 'LITHUANIA'),"
					+ "('LUX', 'LUXEMBOURG'),"
					+ "('MAC', 'MACAU'),"
					+ "('MKD', 'MACEDONIA'),"
					+ "('MDG', 'MADAGASCAR'),"
					+ "('MWI', 'MALAWI'),"
					+ "('MYS', 'MALAYSIA'),"
					+ "('MDV', 'MALDIVES'),"
					+ "('MLI', 'MALI'),"
					+ "('MLT', 'MALTA'),"
					+ "('MHL', 'MARSHALL ISLANDS'),"
					+ "('MTQ', 'MARTINIQUE'),"
					+ "('MRT', 'MAURITANIA'),"
					+ "('MUS', 'MAURITIUS'),"
					+ "('MYT', 'MAYOTTE'),"
					+ "('MEX', 'MEXICO'),"
					+ "('FSM', 'MICRONESIA, FEDERATED STATES OF'),"
					+ "('MDA', 'MOLDOVA, REPUBLIC OF'),"
					+ "('MCO', 'MONACO'),"
					+ "('MNG', 'MONGOLIA'),"
					+ "('MNE', 'MONTENEGRO'),"
					+ "('MSR', 'MONTSERRAT'),"
					+ "('MAR', 'MOROCCO'),"
					+ "('MOZ', 'MOZAMBIQUE'),"
					+ "('MMR', 'MYANMAR'),"
					+ "('NAM', 'NAMIBIA'),"
					+ "('NRU', 'NAURU'),"
					+ "('NPL', 'NEPAL'),"
					+ "('NLD', 'NETHERLANDS'),"
					+ "('ANT', 'NETHERLANDS ANTILLES'),"
					+ "('NCL', 'NEW CALEDONIA'),"
					+ "('NZL', 'NEW ZEALAND'),"
					+ "('NIC', 'NICARAGUA'),"
					+ "('NER', 'NIGER'),"
					+ "('NGA', 'NIGERIA'),"
					+ "('NIU', 'NIUE'),"
					+ "('NFK', 'NORFOLK ISLAND'),"
					+ "('MNP', 'NORTHERN MARIANA ISLANDS'),"
					+ "('NOR', 'NORWAY'),"
					+ "('OMN', 'OMAN'),"
					+ "('PAK', 'PAKISTAN'),"
					+ "('PLW', 'PALAU'),"
					+ "('PAN', 'PANAMA'),"
					+ "('PNG', 'PAPUA NEW GUINEA'),"
					+ "('PRY', 'PARAGUAY'),"
					+ "('PER', 'PERU'),"
					+ "('PHL', 'PHILIPPINES'),"
					+ "('PCN', 'PITCAIRN'),"
					+ "('POL', 'POLAND'),"
					+ "('PRT', 'PORTUGAL'),"
					+ "('PRI', 'PUERTO RICO'),"
					+ "('QAT', 'QATAR'),"
					+ "('REU', 'REUNION'),"
					+ "('ROM', 'ROMANIA'),"
					+ "('RUS', 'RUSSIAN FEDERATION'),"
					+ "('RWA', 'RWANDA'),"
					+ "('KNA', 'SAINT KITTS AND NEVIS'),"
					+ "('LCA', 'SAINT LUCIA'),"
					+ "('VCT', 'SAINT VINCENT AND THE GRENADINES'),"
					+ "('WSM', 'SAMOA'),"
					+ "('SMR', 'SAN MARINO'),"
					+ "('STP', 'SAO TOME AND PRINCIPE'),"
					+ "('SAU', 'SAUDI ARABIA'),"
					+ "('SEN', 'SENEGAL'),"
					+ "('SRB', 'SERBIA'),"
					+ "('SYC', 'SEYCHELLES'),"
					+ "('SLE', 'SIERRA LEONE'),"
					+ "('SGP', 'SINGAPORE'),"
					+ "('SVK', 'SLOVAKIA'),"
					+ "('SVN', 'SLOVENIA'),"
					+ "('SLB', 'SOLOMON ISLANDS'),"
					+ "('SOM', 'SOMALIA'),"
					+ "('ZAF', 'SOUTH AFRICA'),"
					+ "('SSD', 'SOUTH SUDAN'),"
					+ "('SGS', 'SOUTH GEORGIA AND SOUTH S.S.'),"
					+ "('ESP', 'SPAIN'),"
					+ "('LKA', 'SRI LANKA'),"
					+ "('SHN', 'ST. HELENA'),"
					+ "('SPM', 'ST. PIERRE AND MIQUELON'),"
					+ "('SDN', 'SUDAN'),"
					+ "('SUR', 'SURINAME'),"
					+ "('SJM', 'SVALBARD AND JAN MAYEN ISLANDS'),"
					+ "('SWZ', 'SWAZILAND'),"
					+ "('SWE', 'SWEDEN'),"
					+ "('CHE', 'SWITZERLAND'),"
					+ "('SYR', 'SYRIAN ARAB REPUBLIC'),"
					+ "('TWN', 'TAIWAN, PROVINCE OF CHINA'),"
					+ "('TJK', 'TAJIKISTAN'),"
					+ "('THA', 'THAILAND'),"
					+ "('TGO', 'TOGO'),"
					+ "('TKL', 'TOKELAU'),"
					+ "('TON', 'TONGA'),"
					+ "('TTO', 'TRINIDAD AND TOBAGO'),"
					+ "('TUN', 'TUNISIA'),"
					+ "('TUR', 'TURKEY'),"
					+ "('TKM', 'TURKMENISTAN'),"
					+ "('TCA', 'TURKS AND CAICOS ISLANDS'),"
					+ "('TUV', 'TUVALU'),"
					+ "('UGA', 'UGANDA'),"
					+ "('UKR', 'UKRAINE'),"
					+ "('ARE', 'UNITED ARAB EMIRATES'),"
					+ "('GBR', 'UNITED KINGDOM'),"
					+ "('USA', 'UNITED STATES'),"
					+ "('UMI', 'U.S. MINOR ISLANDS'),"
					+ "('URY', 'URUGUAY'),"
					+ "('UZB', 'UZBEKISTAN'),"
					+ "('VUT', 'VANUATU'),"
					+ "('VEN', 'VENEZUELA'),"
					+ "('VNM', 'VIETNAM'),"
					+ "('VGB', 'VIRGIN ISLANDS - BRITISH'),"
					+ "('VIR', 'VIRGIN ISLANDS - U.S.'),"
					+ "('WLF', 'WALLIS AND FUTUNA ISLANDS'),"
					+ "('ESH', 'WESTERN SAHARA'),"
					+ "('YEM', 'YEMEN'),"
					+ "('ZMB', 'ZAMBIA'),"
					+ "('ZWE ', 'ZIMBABWE'),"
					+ "('XXX ', 'UNKNOWN ');";
	/*
	 * USER TABLE
	 */

	public static final String SQL_CREATE_USER_TABLE = "CREATE TABLE "
			+ Contracts.User.TABLE_NAME + "( " + "_ID" + INTEGER_TYPE
			+ PRIMARY_KEY + COMMA_SEP + Contracts.User.COLUMN_NAME_USER_NAME
			+ TEXT_TYPE + NO_CASE + COMMA_SEP + Contracts.User.COLUMN_NAME_USER_FULL_NAME
			+ TEXT_TYPE + NO_CASE + COMMA_SEP
			+ Contracts.User.COLUMN_NAME_PASSWORD + TEXT_TYPE + COMMA_SEP
			+ Contracts.User.COLUMN_NAME_LOCKED + INTEGER_TYPE + COMMA_SEP
			+ Contracts.User.COLUMN_NAME_EXPIRED + INTEGER_TYPE + COMMA_SEP
			+ Contracts.User.COLUMN_NAME_EXPIRY_DATE + LONG_TYPE + COMMA_SEP
			+ Contracts.User.COLUMN_NAME_LOGIN_ATTEMPTS + INTEGER_TYPE
			+ COMMA_SEP + Contracts.User.COLUMN_NAME_LAST_LOGIN + LONG_TYPE
			+ COMMA_SEP + Contracts.User.COLUMN_NAME_MODIFIED_DATE + LONG_TYPE
			+ COMMA_SEP + Contracts.User.COLUMN_NAME_CREATED_DATE + LONG_TYPE
			+ COMMA_SEP + Contracts.User.COLUMN_NAME_SALT + TEXT_TYPE + ");";

	/**
	 * Defines the string used in the SQL statement for deleting the BirthRecord
	 * table
	 */
	public static final String SQL_DELETE_USER_TABLE = "DROP TABLE IF EXISTS "
			+ Contracts.User.TABLE_NAME;

	public static abstract class User implements BaseColumns {
		public static final Uri CONTENT_URI = Uri
				.parse("content://tz.co.rita.birthregistration.birthregistrationprovider/user");
		public static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.rita.birthregistration.user";
		public static final String MULTIPLE_RECORDS_MIME_TYPE = "vnd.android.cursor.dir/rita.birthregistration.muser";
		public static final String TABLE_NAME = "user";
		public static final String COLUMN_NAME_USER_NAME = "user_name";
		public static final String COLUMN_NAME_USER_FULL_NAME = "user_full_name";
		public static final String COLUMN_NAME_PASSWORD = "password";
		public static final String COLUMN_NAME_LOCKED = "locked";
		public static final String COLUMN_NAME_EXPIRED = "expired";
		public static final String COLUMN_NAME_EXPIRY_DATE = "expiry_date";
		public static final String COLUMN_NAME_LOGIN_ATTEMPTS = "login_attempts";
		public static final String COLUMN_NAME_LAST_LOGIN = "last_login";
		public static final String COLUMN_NAME_MODIFIED_DATE = "modified_date";
		public static final String COLUMN_NAME_CREATED_DATE = "created_date";
		public static final String COLUMN_NAME_SALT = "salt";

	}

}
