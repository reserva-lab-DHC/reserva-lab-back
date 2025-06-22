package com.domhelder.reserve.entity;

import java.util.List;

public class DiaReserva {

    private DiasSemana diaReserva;

    private List<Horarios> horarios;


    public DiasSemana getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(DiasSemana diaReserva) {
        this.diaReserva = diaReserva;
    }

    public List<Horarios> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horarios> horarios) {
        this.horarios = horarios;
    }

}
