public class TestDiesEntreDates_Adan_Inarejos {
    public static void main(String[] args) {
        DiesEntreDates_Adan_Inarejos d1= new DiesEntreDates_Adan_Inarejos();
        try {
            DataXS fechaInicio = new DataXS("12/12/2017");
            DataXS fechaDestino = new DataXS("01/01/2018");
            System.out.println(d1.nombreDiesTotals(fechaInicio, fechaDestino));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    }

