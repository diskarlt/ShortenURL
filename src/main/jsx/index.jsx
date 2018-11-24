import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom';
import { Alert, Button, Form, FormGroup, Input, Label } from 'reactstrap';
import '../webapp/css/custom.css';

class ShortenResult extends React.Component {
    constructor(props) {
        super(props);
        this.copyToClipboard = this.copyToClipboard.bind(this);
    }

    copyToClipboard(e) {
        var t = document.createElement("textarea");
        document.body.appendChild(t);
        t.value = this.props.shortenUrl;
        t.select();
        document.execCommand('copy');
        document.body.removeChild(t);
        alert('Copied!');
    }

    render() {
        return (
            <div className="result">
                <Alert color="success">{ this.props.shortenUrl }</Alert>
                <Button onClick={this.copyToClipboard}>Copy to Clipboard</Button>
            </div>
        );
    }
}

class MainPage extends React.Component {
    constructor() {
        super();

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.state = {
            targetUrl: null,
            shortenUrl: null
        }
    }

    handleChange(e) {
        this.setState({
            targetUrl: e.target.value
        })
    }

    handleSubmit(e) {
        e.preventDefault();
        var data = {
            "targetUrl": this.state.targetUrl
        }

        console.log(JSON.stringify(data));

        fetch('/shortenURL/create', {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(data),
        }).then(response => response.json())
        .then(data => {
            console.log(JSON.stringify(data));
            this.setState({shortenUrl : data.shortenUrl});           
        });
    }
 
    render() {
        return <div className="main">
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label for="targetUrl">Shorten URL</Label>
                    <Input type="URL" name="targetUrl" value={this.state.targetUrl} onChange={this.handleChange} placeholder="input URL" />
                </FormGroup>
                <Button>Submit</Button>
                { this.state.shortenUrl ? <ShortenResult shortenUrl={this.state.shortenUrl}/> : null }
            </Form>
        </div>;
    }
 
}
 
ReactDOM.render(<MainPage/>, document.getElementById('root'));