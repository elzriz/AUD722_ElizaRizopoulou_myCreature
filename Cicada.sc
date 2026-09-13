//Eliza Rizopoulou TX2019011

Cicada : Creature {

    dawn {
        this.substitute({
            var trig, sig, pan;
            trig = Dust.kr(LFNoise1.kr(0.3).range(1.5, 5));
            pan = TRand.kr(-0.8, 0.8, trig);
            sig = PlayBuf.ar(1, this.buffer, rate: TRand.kr(0.9, 1.2, trig) * BufRateScale.kr(this.buffer), trigger: trig, loop: 0);
            sig = sig * EnvGen.kr(Env.perc(0.005, 0.08), trig);
            Pan2.ar((sig * 12.0).tanh, pan);
        }.play, releaseTime: 0.8);
    }

    day {
        this.substitute({
            var heatSwell, tymbalPulse, sig, pan;
            tymbalPulse = LFTri.ar(48).range(0.2, 1.0);
            heatSwell = SinOsc.kr(0.1).range(0.65, 1.0);
            pan = SinOsc.kr(0.07).range(-0.55, 0.55);
            sig = PlayBuf.ar(1, this.buffer, rate: 1.3 * BufRateScale.kr(this.buffer), loop: 1);
            sig = sig * tymbalPulse * heatSwell;
            Pan2.ar((sig * 16.0).tanh, pan);
        }.play, releaseTime: 0.5);
    }

    dusk {
        this.substitute({
            var rhythm, sweep, sig;
            rhythm = LFPulse.ar(18, 0, 0.55).range(0.3, 1.0);
            sweep = SinOsc.kr(0.2).range(-0.6, 0.6);
            sig = PlayBuf.ar(1, this.buffer, rate: 0.82 * BufRateScale.kr(this.buffer), loop: 1);
            sig = sig * rhythm * 16.0;
            Pan2.ar(sig.tanh, sweep);
        }.play, releaseTime: 0.8);
    }

    night {
        this.release(1.5);
    }

    danger {
        this.substitute({
            var stutter, pitchJitter, sig, pan;
            stutter = LFPulse.ar(LFNoise0.kr(16).range(20, 65), 0, 0.4);
            pitchJitter = LFNoise0.kr(12).range(1.7, 2.5) * BufRateScale.kr(this.buffer);
            pan = LFNoise1.kr(8).range(-0.95, 0.95);
            sig = PlayBuf.ar(1, this.buffer, rate: pitchJitter, loop: 1);
            sig = sig * stutter;
            Pan2.ar((sig * 18.0).tanh, pan);
        }.play, releaseTime: 0.15);
    }
}
