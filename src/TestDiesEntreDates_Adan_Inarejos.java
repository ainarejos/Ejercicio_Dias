public class TestDiesEntreDates_Adan_Inarejos {
    public static void main(String[] args) {
        DiesEntreDates_Adan_Inarejos d1= new DiesEntreDates_Adan_Inarejos();
        try {
            DataXS fechaInicio = new DataXS("20/03/2020");
            DataXS fechaDestino = new DataXS("01/01/2025");
            System.out.println(d1.nombreDiesTotals(fechaInicio, fechaDestino));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    }

