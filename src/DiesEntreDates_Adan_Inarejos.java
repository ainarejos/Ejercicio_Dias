public class DiesEntreDates_Adan_Inarejos extends CalcularDiesEntreDates {
    //Atributos.
    int diasMes;
    int diasRestoAñoInicial;
    int diasRestoAñoDestino;
    int numDiasAñoBisiesto;
    //El metodo diasMes nos devuelve los dias que tienen cada mes en concreto.
    @Override
    protected int diesMes(int mes) {
      switch (mes){
          case 1,3,5,7,8,10,12:
              this.diasMes=31;
              break;
          case 2:
              this.diasMes=28;
          case 4,6,9,11:
              this.diasMes=30;

      }
      return this.diasMes;
    }
    //diasMesInicial nos devuelve los dias que faltan para completar el mes inicial.
    @Override
    protected int diesMesInicial(DataXS dataXS) {
        return diesMes(dataXS.mes)-dataXS.dia;
    }
    // Este metodo nos devuelve los dias transcurridos desde el comienzo del mes hasta el dia destino.
    @Override
    protected int diesMesDesti(DataXS dataXS) {
        return dataXS.dia;
    }
    //diesResteAnyInicial devuelve los dias desde el mes siguente a la fecha inicio, hasta el final de ese mismo año.
    @Override
    protected int diesResteAnyInicial(DataXS datainicial) {
        for (int i = 0; i < 12-datainicial.mes ; i++) {
           diasRestoAñoInicial+=diesMes(datainicial.mes+i);
        }
        return diasRestoAñoInicial;
    }
    //diesResteAnyDesty devuelve  los dias transcurridos desde principio de año hasta el mes anterior de la fecha destino.
    @Override
    protected int diesResteAnyDesti(DataXS datadesti) {
        for (int i = 0; i <datadesti.mes-1 ; i++) {
            diasRestoAñoDestino+=diesMes(datadesti.mes-i);
        }
        return diasRestoAñoDestino;
    }
    //diesNumAnysComplets devuelve los dias transcurridos entre los año de la fecha inicial y destino.
    @Override
    protected int diesNumAnysComplets(DataXS datainicial, DataXS datadesti) {
        return 365*((datadesti.any-datainicial.any)-1);
    }
    //numDiesPerAnydeTraspas devuelve los años extra de cada año bisiesto que haya entre las dos fechas.
    @Override
    protected int numDiesPerAnysdeTraspas(DataXS datainicial, DataXS datadesti) {
        if (datainicial.mes<3){
            numDiasAñoBisiesto++;
        }
        for (int i = 0; i <((datadesti.any-datainicial.any)-1) ; i++) {
            if (anyDeTraspas(datainicial.any + i)) {
                numDiasAñoBisiesto++;
            }
        }
            if (anyDeTraspas(datadesti.any)){
                numDiasAñoBisiesto++;
            }
        return numDiasAñoBisiesto;
    }
    //anyDeTraspas comprueba cada año si es bisiesto o no.
    @Override
    protected boolean anyDeTraspas(int any) {
        return ((any % 400 == 0) || ((any % 4 == 0) && !(any % 100 == 0)));
    }
}
