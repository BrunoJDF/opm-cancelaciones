 package modulo.proyecto.utils;

 import java.sql.Timestamp;
 import java.text.DateFormat;
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.Calendar;
 import java.util.Date;
 
 public class DateUtils {
   public static String getToDay() {
     String fecha = "";
     Date fechaActual = new Date();
     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
     fecha = formato.format(fechaActual);
     return fecha;
   }
   
   public static Date getToday() {
     Date date = new Date();
     Date fechaToday = null;
     DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
     String fecha = "";
     fecha = parseDateToString(date);
     try {
       fechaToday = dformat.parse(fecha);
     } catch (Exception e) {
       e.printStackTrace();
     } 
     return fechaToday;
   }
   
   public static Date getTodayComplete() {
     Date date = new Date();
     Date fechaToday = null;
     DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
     String fecha = "";
     fecha = parseDateToStringComplete(date);
     try {
       fechaToday = dformat.parse(fecha);
     } catch (Exception e) {
       e.printStackTrace();
     } 
     return fechaToday;
   }
   
   public static String parseDateTimeToString(Date date) {
     if (date == null) {
       return null;
     }
     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseDateToString(Date date) {
     if (date == null) {
       return null;
     }
     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseDateToStringComplete(Date date) {
     if (date == null) {
       return null;
     }
     SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseDateToStringFormatUSA(Date date) {
     if (date == null) {
       return null;
     }
     SimpleDateFormat formato = new SimpleDateFormat("MM/dd/yyyy");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseTimeLongToString(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("HHmmss");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseTimeLongToStringFinancial(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseTimeToString(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseDateToSQLString(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseDateToSQLStringfinancial(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseDateTimeToSQLString(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseDateTimeMillToSQLString(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
     
     String fecha = formato.format(date);
     return fecha;
   }
 
   
   public static Timestamp parseStringSQLToDateTimeMill(String fecha, String formato) throws Exception {
     SimpleDateFormat sdf = new SimpleDateFormat(formato);
     Date date = sdf.parse(fecha);
     return new Timestamp(date.getTime());
   }
 
 
   
   public static Timestamp parseStringSQLToDateTimeMill(Date fecha, String formato) throws Exception {
     SimpleDateFormat sdf = new SimpleDateFormat(formato);
     sdf.format(fecha);
     return new Timestamp(fecha.getTime());
   }
   
   public static String parseLongDate(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String parseExtraLongDate(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static Date parseDate(String fecha, String formato) {
     Date ldFecha = null;
     SimpleDateFormat sdf = new SimpleDateFormat(formato);
     try {
       ldFecha = sdf.parse(fecha);
     } catch (ParseException e) {
       e.printStackTrace();
     } 
     return ldFecha;
   }
   
   public static Date getNextWeekDay(Date pdDate) {
     Calendar loCal = Calendar.getInstance();
     loCal.setTime(pdDate);
     loCal.add(6, 1);
     int loDayWeek = loCal.get(7);
     int nDaysToAdd = 0;
     if (loDayWeek == 7) {
       nDaysToAdd = 2;
     } else if (loDayWeek == 1) {
       nDaysToAdd = 1;
     } 
     loCal.add(6, nDaysToAdd);
     return loCal.getTime();
   }
   public static Date moveWeekDay(Date pdDate, int nDays) {
     int nDireccion;
     Calendar loCal = Calendar.getInstance();
     loCal.setTime(pdDate);
     
     if (nDays > 0) {
       nDireccion = 1;
     } else {
       nDireccion = -1;
       nDays *= -1;
     } 
     for (int i = 0; i < nDays; ) {
       loCal.add(6, nDireccion * 1);
       int loDayWeek = loCal.get(7);
       if (loDayWeek != 7 && loDayWeek != 1) {
         i++;
       }
     } 
     return loCal.getTime();
   }
   
   public static Date getLastWeekDay(Date pdDate) {
     Calendar loCal = Calendar.getInstance();
     loCal.setTime(pdDate);
     loCal.add(6, -1);
     int loDayWeek = loCal.get(7);
     int nDaysToSubstract = 0;
     if (loDayWeek == 7) {
       nDaysToSubstract = 1;
     } else if (loDayWeek == 1) {
       nDaysToSubstract = 2;
     } 
     loCal.add(6, -1 * nDaysToSubstract);
     return loCal.getTime();
   }
 
   
   public static long differenceInDays(Date pDate1, Date pDate2, boolean pbCountWeekends) {
     long daysBetween = 0L;
     Calendar date1 = Calendar.getInstance();
     date1.setTime(pDate1);
     date1.set(date1.get(1), date1.get(2), date1.get(5), 0, 0, 0);
     Calendar date2 = Calendar.getInstance();
     date2.setTime(pDate2);
     date2.set(date2.get(1), date2.get(2), date2.get(5), 0, 0, 0);
     Calendar startDate = null;
     Calendar endDate = null;
     int esPositivo = 1;
     if (date1.before(date2)) {
       esPositivo = 1;
       startDate = date1;
       endDate = date2;
     } else if (date1.after(date2)) {
       esPositivo = -1;
       startDate = date2;
       endDate = date1;
     } else {
       daysBetween = 0L;
     } 
     if (startDate != null && endDate != null) {
       while (startDate.before(endDate)) {
         startDate.add(5, 1);
         if (pbCountWeekends) {
           daysBetween++; continue;
         } 
         int lcurrentDay = startDate.get(7);
         if (lcurrentDay != 7 && lcurrentDay != 1) {
           daysBetween++;
         }
       } 
     }
     
     daysBetween *= esPositivo;
     return daysBetween;
   }
   
   public static long differenceInDays(Date pDate1, Date pDate2) {
     return differenceInDays(pDate1, pDate2, true);
   }
 
   
   public static Date setTime(Date date, int hour, int minute, int second, int millisecond) {
     Calendar cal = Calendar.getInstance();
     cal.setTime(date);
     cal.set(11, hour);
     cal.set(12, minute);
     cal.set(13, second);
     cal.set(14, millisecond);
     return cal.getTime();
   }
   
   public static boolean isSameDay(Date pDate1, Date pDate2) {
     Calendar date1 = Calendar.getInstance();
     date1.setTime(pDate1);
     Calendar date2 = Calendar.getInstance();
     date2.setTime(pDate2);
     boolean lbIsSameDay = (date1.get(1) == date2.get(1) && date1.get(6) == date2.get(6));
     
     return lbIsSameDay;
   }
   
   public static Date addTimeToDate(Date pdFecha, Date pdHora) {
     Calendar loCalFecha = Calendar.getInstance();
     loCalFecha.setTime(pdFecha);
     Calendar loCalHora = Calendar.getInstance();
     loCalHora.setTime(pdHora);
     loCalFecha.set(11, loCalHora.get(11));
     loCalFecha.set(12, loCalHora.get(12));
     pdFecha = loCalFecha.getTime();
     return pdFecha;
   }
   
   public static String parseFechaSinFomato(String fechOrignal) {
     String mesFinal, diaFinal, fechFinal = null;
     StringBuffer fechDia = new StringBuffer();
     StringBuffer fechMes = new StringBuffer();
     StringBuffer fechAnio = new StringBuffer();
     boolean mesCompleto = false;
     boolean diaCompleto = false;
     
     int contMes = 0;
     int contDia = 0;
     int contAnio = 0;
     for (int i = 0; i < fechOrignal.length(); i++) {
       char aux1 = fechOrignal.charAt(i);
       if (contMes == 0) {
         if (aux1 != '/') {
           fechMes.append(aux1);
         } else {
           mesCompleto = true;
         } 
       }
       if (contDia == 1) {
         if (aux1 != '/') {
           fechDia.append(aux1);
         } else {
           diaCompleto = true;
         } 
       }
       if (contAnio == 1) {
         if (aux1 == ' ') {
           break;
         }
         fechAnio.append(aux1);
       } 
       if (mesCompleto) {
         contMes++;
         contDia++;
         mesCompleto = false;
       } 
       if (diaCompleto) {
         contDia++;
         contAnio++;
         diaCompleto = false;
       } 
     } 
     
     if (fechMes.length() == 1) {
       mesFinal = "0" + fechMes;
     } else {
       mesFinal = fechMes.toString();
     } 
     
     if (fechDia.length() == 1) {
       diaFinal = "0" + fechDia;
     } else {
       diaFinal = fechDia.toString();
     } 
     fechFinal = String.valueOf(diaFinal) + "-" + mesFinal + "-" + fechAnio;
     return fechFinal;
   }
   
   public static String parseDateInvert(Date date) {
     SimpleDateFormat formato = new SimpleDateFormat("yyMMdd");
     String fecha = formato.format(date);
     return fecha;
   }
   
   public static String invertirFecha(String fechaOriginal) {
     String dateFormat = null;
     String dia = fechaOriginal.substring(0, 2);
     String mes = fechaOriginal.substring(3, 5);
     String anio = fechaOriginal.substring(8, 10);
     dateFormat = String.valueOf(anio) + mes + dia;
     return dateFormat;
   }
   
   public static String invertirFechaArchivo(String fechaOriginal) {
     String dateFormat = null;
     String dia = fechaOriginal.substring(0, 2);
     String mes = fechaOriginal.substring(3, 5);
     String anio = fechaOriginal.substring(6, 10);
     dateFormat = String.valueOf(anio) + mes + dia;
     return dateFormat;
   }
   
   public static String invertirFechaArchivoID(String fechaOriginal) {
     String dateFormat = null;
     String dia = fechaOriginal.substring(0, 2);
     String mes = fechaOriginal.substring(3, 5);
     String anio = fechaOriginal.substring(6, 10);
     dateFormat = String.valueOf(dia) + mes + anio;
     return dateFormat;
   }
   
   public static String formateaFechaConDiagonal(String fechaOriginal) {
     System.out.println(fechaOriginal);
     String dateFormat = null;
     String dia = fechaOriginal.substring(0, 2);
     String mes = fechaOriginal.substring(3, 5);
     String anio = fechaOriginal.substring(6, 10);
     dateFormat = String.valueOf(anio) + "/" + mes + "/" + dia;
     return dateFormat;
   }
   
   public static long diasDiferenciaFechas(Date fecha1, Date fecha2) {
     Calendar cal1 = Calendar.getInstance();
     cal1.setTime(fecha1);
     Calendar cal2 = Calendar.getInstance();
     cal2.setTime(fecha2);
     
     cal1.set(cal1.get(1), cal1.get(2), cal1.get(5));
     cal2.set(cal2.get(1), cal2.get(2), cal2.get(5));
     
     long milis1 = cal1.getTimeInMillis();
     long milis2 = cal2.getTimeInMillis();
     
     long diff = milis2 - milis1;
     System.out.println("En milisegundos: " + diff + " milisegundos.");
     
     long diffDays = diff / 86400000L;
     System.out.println("En dias: " + diffDays + " dias.");
     return diffDays;
   }
   
   public static String getYear() {
     Date hoy = new Date();
     Date ayer = new Date(hoy.getTime() - 86400000L);
     
     SimpleDateFormat formato = new SimpleDateFormat("yyyy");
     String fecha = formato.format(ayer);
     return fecha;
   }
   
   public static Date getDateYesterday() {
     Date fechaAyer = null;
     Date hoy = new Date();
     Date ayer = new Date(hoy.getTime() - 86400000L);
     DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy");
     String fecha = "";
     fecha = parseDateToString(ayer);
     try {
       fechaAyer = dformat.parse(fecha);
     } catch (Exception e) {
       e.printStackTrace();
     } 
     return fechaAyer;
   }
 
 
 
 
   
   public static Timestamp getToDayTimeMill() {
     Timestamp toDay = null;
     try {
       return parseStringSQLToDateTimeMill(new Date(), "yy-MM-dd HH:mm:ss.SSS");
     }
     catch (Exception e) {
       e.printStackTrace();
       
       return toDay;
     } 
   }
 }


/* Location:              C:\Users\cjimenezc\Documents\PROYECTOS OPM\Jars\OPM_CancelacionesMasivas.jar!\com\opm\modulo\proyect\\utils\DateUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */