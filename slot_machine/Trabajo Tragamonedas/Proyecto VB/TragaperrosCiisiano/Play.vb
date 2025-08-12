Module play
    Public Sub Run()
        Form1.Timer1.Enabled = True
    End Sub

    Public Sub Revisar(ByVal a As Integer, ByVal b As Integer, ByVal c As Integer)
        If (a = b) And (b = c) Then
            Select Case a
                Case 2
                    MsgBox("Has Ganado! Tus Creditos Seran Duplicados", MsgBoxStyle.OkOnly, "Ganaste!")
                    Form1.c.Creditox2()
                Case 6
                    MsgBox("Has Ganado! Tus Creditos Seran Triplicados", MsgBoxStyle.OkOnly, "Ganaste!")
                    Form1.c.Creditox3()
                Case 4
                    MsgBox("Has Ganado! Tus Creditos Seran Cuadruplicados", MsgBoxStyle.OkOnly, "Ganaste!")
                    Form1.c.Creditox4()
                Case 0
                    MsgBox("Has Ganado 1000 Creditos!", MsgBoxStyle.OkOnly, "Ganaste!")
                    Form1.c.Creditokiwi()
                Case 8
                    MsgBox("Has Perdido 2500 Creditos! ", MsgBoxStyle.OkOnly, "Que Pena!")
                    Form1.c.CreditoPodrido()
                Case 10
                    MsgBox("Has Ganado 500 Creditos!", MsgBoxStyle.OkOnly, "Ganaste!")
                    Form1.c.CreditoPera()
                Case 12
                    MsgBox("Has Ganado 250 Creditos!", MsgBoxStyle.OkOnly, "Ganaste!")
                    Form1.c.Creditoplatano()
            End Select
        End If
    End Sub
End Module