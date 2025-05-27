package com.domhelder.reserve.dto;

import com.domhelder.reserve.entity.Horarios;
import com.domhelder.reserve.entity.StatusReserva;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ReservaDTO {
    private UUID id;
    private LocalDate dataReserva;
    private List<Horarios> horariosReservados;
    private StatusReserva status;
    private UUID solicitanteId;
    private UUID salaReservadaId;
    private String disciplinaRelacionada;
    private String motivoReserva;
    private LocalDateTime dataSolicitacao;
    private LocalDateTime dataConclusao;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public List<Horarios> getHorariosReservados() {
        return horariosReservados;
    }

    public void setHorariosReservados(List<Horarios> horariosReservados) {
        this.horariosReservados = horariosReservados;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public UUID getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(UUID solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public UUID getSalaReservadaId() {
        return salaReservadaId;
    }

    public void setSalaReservadaId(UUID salaReservadaId) {
        this.salaReservadaId = salaReservadaId;
    }

    public String getDisciplinaRelacionada() {
        return disciplinaRelacionada;
    }

    public void setDisciplinaRelacionada(String disciplinaRelacionada) {
        this.disciplinaRelacionada = disciplinaRelacionada;
    }

    public String getMotivoReserva() {
        return motivoReserva;
    }

    public void setMotivoReserva(String motivoReserva) {
        this.motivoReserva = motivoReserva;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }
}
