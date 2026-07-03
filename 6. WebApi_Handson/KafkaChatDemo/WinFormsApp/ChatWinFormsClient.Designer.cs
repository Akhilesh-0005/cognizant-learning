namespace KafkaChatDemo.WinFormsApp
{
    partial class ChatWinFormsClient
    {
        private System.ComponentModel.IContainer components = null;
        private System.Windows.Forms.ListBox chatListBox;
        private System.Windows.Forms.TextBox messageTextBox;
        private System.Windows.Forms.Button sendButton;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null)) components.Dispose();
            base.Dispose(disposing);
        }

        private void InitializeComponent()
        {
            this.chatListBox = new System.Windows.Forms.ListBox();
            this.messageTextBox = new System.Windows.Forms.TextBox();
            this.sendButton = new System.Windows.Forms.Button();
            this.SuspendLayout();

            // chatListBox
            this.chatListBox.Dock = System.Windows.Forms.DockStyle.Top;
            this.chatListBox.Height = 300;

            // messageTextBox
            this.messageTextBox.Dock = System.Windows.Forms.DockStyle.Left;
            this.messageTextBox.Width = 300;
            this.messageTextBox.Top = 310;

            // sendButton
            this.sendButton.Text = "Send";
            this.sendButton.Top = 310;
            this.sendButton.Left = 310;
            this.sendButton.Click += new System.EventHandler(this.SendButton_Click);

            // ChatWinFormsClient
            this.ClientSize = new System.Drawing.Size(400, 350);
            this.Controls.Add(this.sendButton);
            this.Controls.Add(this.messageTextBox);
            this.Controls.Add(this.chatListBox);
            this.Text = "Kafka Chat Client";
            this.ResumeLayout(false);
        }
    }
}
