<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form reemplaza a Dispose para limpiar la lista de componentes.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Requerido por el Diseñador de Windows Forms
    Private components As System.ComponentModel.IContainer

    'NOTA: el Diseñador de Windows Forms necesita el siguiente procedimiento
    'Se puede modificar usando el Diseñador de Windows Forms.  
    'No lo modifique con el editor de código.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.Timer1 = New System.Windows.Forms.Timer(Me.components)
        Me.iList = New System.Windows.Forms.ImageList(Me.components)
        Me.lb_cre = New System.Windows.Forms.Label
        Me.btn_cobrar = New System.Windows.Forms.Button
        Me.pB1 = New System.Windows.Forms.PictureBox
        Me.pB2 = New System.Windows.Forms.PictureBox
        Me.pB3 = New System.Windows.Forms.PictureBox
        Me.bola = New System.Windows.Forms.PictureBox
        Me.redbank = New System.Windows.Forms.PictureBox
        Me.btnLanzar = New System.Windows.Forms.Button
        Me.bt_din = New System.Windows.Forms.Button
        Me.Label1 = New System.Windows.Forms.Label
        Me.ToolTip1 = New System.Windows.Forms.ToolTip(Me.components)
        CType(Me.pB1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.pB2, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.pB3, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.bola, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.redbank, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Timer1
        '
        Me.Timer1.Interval = 300
        '
        'iList
        '
        Me.iList.ImageStream = CType(resources.GetObject("iList.ImageStream"), System.Windows.Forms.ImageListStreamer)
        Me.iList.TransparentColor = System.Drawing.Color.Transparent
        Me.iList.Images.SetKeyName(0, "00-kiwi.bmp")
        Me.iList.Images.SetKeyName(1, "01-kiwi-lim.bmp")
        Me.iList.Images.SetKeyName(2, "02-limon.bmp")
        Me.iList.Images.SetKeyName(3, "03-limon-manzana.bmp")
        Me.iList.Images.SetKeyName(4, "04-manzana.bmp")
        Me.iList.Images.SetKeyName(5, "05-manzana-naranja.bmp")
        Me.iList.Images.SetKeyName(6, "06-naranja.bmp")
        Me.iList.Images.SetKeyName(7, "07-naranja-podrida.bmp")
        Me.iList.Images.SetKeyName(8, "08-ManzanaPodrida.bmp")
        Me.iList.Images.SetKeyName(9, "09-podrida-pera.bmp")
        Me.iList.Images.SetKeyName(10, "10-pera.bmp")
        Me.iList.Images.SetKeyName(11, "11-pera-platano.bmp")
        Me.iList.Images.SetKeyName(12, "12-platano.bmp")
        Me.iList.Images.SetKeyName(13, "13-platano-kiwi.bmp")
        '
        'lb_cre
        '
        Me.lb_cre.BackColor = System.Drawing.Color.DarkRed
        Me.lb_cre.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.lb_cre.Font = New System.Drawing.Font("Microsoft Sans Serif", 27.75!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lb_cre.ForeColor = System.Drawing.Color.Red
        Me.lb_cre.Location = New System.Drawing.Point(87, 107)
        Me.lb_cre.Name = "lb_cre"
        Me.lb_cre.Size = New System.Drawing.Size(288, 42)
        Me.lb_cre.TabIndex = 0
        Me.lb_cre.Text = "0"
        Me.lb_cre.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        Me.ToolTip1.SetToolTip(Me.lb_cre, "Creditos Disponibles")
        '
        'btn_cobrar
        '
        Me.btn_cobrar.BackColor = System.Drawing.Color.Transparent
        Me.btn_cobrar.Image = Global.TragaperrosCiisiano.My.Resources.Resources.cob_1
        Me.btn_cobrar.Location = New System.Drawing.Point(184, 284)
        Me.btn_cobrar.Name = "btn_cobrar"
        Me.btn_cobrar.Size = New System.Drawing.Size(97, 50)
        Me.btn_cobrar.TabIndex = 1
        Me.ToolTip1.SetToolTip(Me.btn_cobrar, "Retirar Dinero")
        Me.btn_cobrar.UseVisualStyleBackColor = False
        '
        'pB1
        '
        Me.pB1.BackColor = System.Drawing.Color.Transparent
        Me.pB1.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pB1.Image = Global.TragaperrosCiisiano.My.Resources.Resources._00_kiwi1
        Me.pB1.Location = New System.Drawing.Point(75, 151)
        Me.pB1.Name = "pB1"
        Me.pB1.Size = New System.Drawing.Size(97, 97)
        Me.pB1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.pB1.TabIndex = 2
        Me.pB1.TabStop = False
        '
        'pB2
        '
        Me.pB2.BackColor = System.Drawing.Color.Transparent
        Me.pB2.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pB2.Image = Global.TragaperrosCiisiano.My.Resources.Resources._00_kiwi1
        Me.pB2.Location = New System.Drawing.Point(184, 151)
        Me.pB2.Name = "pB2"
        Me.pB2.Size = New System.Drawing.Size(97, 97)
        Me.pB2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.pB2.TabIndex = 3
        Me.pB2.TabStop = False
        '
        'pB3
        '
        Me.pB3.BackColor = System.Drawing.Color.Transparent
        Me.pB3.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D
        Me.pB3.Image = Global.TragaperrosCiisiano.My.Resources.Resources._00_kiwi1
        Me.pB3.Location = New System.Drawing.Point(291, 151)
        Me.pB3.Name = "pB3"
        Me.pB3.Size = New System.Drawing.Size(97, 97)
        Me.pB3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.pB3.TabIndex = 4
        Me.pB3.TabStop = False
        '
        'bola
        '
        Me.bola.BackColor = System.Drawing.Color.Transparent
        Me.bola.Image = Global.TragaperrosCiisiano.My.Resources.Resources.bola
        Me.bola.Location = New System.Drawing.Point(400, 79)
        Me.bola.Name = "bola"
        Me.bola.Size = New System.Drawing.Size(60, 60)
        Me.bola.TabIndex = 5
        Me.bola.TabStop = False
        '
        'redbank
        '
        Me.redbank.BackColor = System.Drawing.Color.Transparent
        Me.redbank.Image = Global.TragaperrosCiisiano.My.Resources.Resources.redbank
        Me.redbank.Location = New System.Drawing.Point(4, 66)
        Me.redbank.Name = "redbank"
        Me.redbank.Size = New System.Drawing.Size(51, 229)
        Me.redbank.TabIndex = 6
        Me.redbank.TabStop = False
        '
        'btnLanzar
        '
        Me.btnLanzar.Location = New System.Drawing.Point(313, 311)
        Me.btnLanzar.Name = "btnLanzar"
        Me.btnLanzar.Size = New System.Drawing.Size(75, 23)
        Me.btnLanzar.TabIndex = 7
        Me.btnLanzar.Text = "Lanzar"
        Me.ToolTip1.SetToolTip(Me.btnLanzar, "Jugar!")
        Me.btnLanzar.UseVisualStyleBackColor = True
        '
        'bt_din
        '
        Me.bt_din.Location = New System.Drawing.Point(313, 274)
        Me.bt_din.Name = "bt_din"
        Me.bt_din.Size = New System.Drawing.Size(75, 23)
        Me.bt_din.TabIndex = 8
        Me.bt_din.Text = "Ingresar"
        Me.ToolTip1.SetToolTip(Me.bt_din, "Depositar Dinero en la Maquina")
        Me.bt_din.UseVisualStyleBackColor = True
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.BackColor = System.Drawing.Color.Transparent
        Me.Label1.Font = New System.Drawing.Font("Mistral", 10.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.Label1.ForeColor = System.Drawing.SystemColors.Control
        Me.Label1.Location = New System.Drawing.Point(1, 324)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(177, 16)
        Me.Label1.TabIndex = 9
        Me.Label1.Text = "Creado Por C.Arriagada y G.Canales"
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImage = Global.TragaperrosCiisiano.My.Resources.Resources.fondo_1
        Me.ClientSize = New System.Drawing.Size(463, 346)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.bt_din)
        Me.Controls.Add(Me.btnLanzar)
        Me.Controls.Add(Me.redbank)
        Me.Controls.Add(Me.bola)
        Me.Controls.Add(Me.pB3)
        Me.Controls.Add(Me.pB2)
        Me.Controls.Add(Me.pB1)
        Me.Controls.Add(Me.btn_cobrar)
        Me.Controls.Add(Me.lb_cre)
        Me.Name = "Form1"
        Me.Text = "Zona Games"
        CType(Me.pB1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.pB2, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.pB3, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.bola, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.redbank, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents Timer1 As System.Windows.Forms.Timer
    Friend WithEvents iList As System.Windows.Forms.ImageList
    Friend WithEvents lb_cre As System.Windows.Forms.Label
    Friend WithEvents btn_cobrar As System.Windows.Forms.Button
    Friend WithEvents pB1 As System.Windows.Forms.PictureBox
    Friend WithEvents pB2 As System.Windows.Forms.PictureBox
    Friend WithEvents pB3 As System.Windows.Forms.PictureBox
    Friend WithEvents bola As System.Windows.Forms.PictureBox
    Friend WithEvents redbank As System.Windows.Forms.PictureBox
    Friend WithEvents btnLanzar As System.Windows.Forms.Button
    Friend WithEvents bt_din As System.Windows.Forms.Button
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents ToolTip1 As System.Windows.Forms.ToolTip

End Class
